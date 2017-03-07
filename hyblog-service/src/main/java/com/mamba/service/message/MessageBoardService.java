package com.mamba.service.message;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.mamba.repository.message.entity.Message;
import com.mamba.repository.message.mapper.MessageBoardMapper;
import com.mamba.service.message.vo.MessageListVO;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Created by mamba on 2017/2/23.
 */
@Service
public class MessageBoardService {
    private static final Logger logger = LoggerFactory.getLogger(MessageBoardService.class);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final LoadingCache<String,Integer> msgCountCache = CacheBuilder.newBuilder()
                                                .maximumSize(10)
                                                .expireAfterWrite(1, TimeUnit.MINUTES)
                                                .build(new CacheLoader<String, Integer>() {
                                                    @Override
                                                    public Integer load(String key) throws Exception {
                                                        return messageBoardMapper.countMessage();
                                                    }
                                                });
    @Autowired
    private MessageBoardMapper messageBoardMapper;

    public List<MessageListVO> getMessageList() {
        List<Message> fatherList = messageBoardMapper.getFatherMessageList();
        if(CollectionUtils.isNotEmpty(fatherList)){
            List<MessageListVO> result = Lists.newArrayListWithCapacity(fatherList.size());
            fatherList.forEach(message -> {
                MessageListVO vo = new MessageListVO();
                BeanUtils.copyProperties(message, vo);
                vo.setCreateTime(message.getCreateTime().format(DATE_TIME_FORMATTER));
                Optional pidOptional = Optional.ofNullable(message.getId());
                if(pidOptional.isPresent()){
                    List<Message> subMessages = messageBoardMapper.getChildrenMessageList((Integer)pidOptional.get());
                    if(CollectionUtils.isNotEmpty(subMessages)){
                        subMessages.forEach(subMessage -> subMessage.setCreateTimeStr(subMessage.getCreateTime().format(DATE_TIME_FORMATTER)));
                    }
                    vo.setSubMessages(subMessages);
                }
                result.add(vo);
            });
            return result;
        }
        return null;
    }

    public Integer countMessage(){

        return msgCountCache.getUnchecked("msgCount");
    }

    public void addOneMessage(String author,String content,Integer pid){
        messageBoardMapper.addMessage(pid,content,author);
    }

    public List<MessageListVO> getLatestMessages() {
        List<Message> metaData = messageBoardMapper.getLatest();
        if(CollectionUtils.isNotEmpty(metaData)){
            List<MessageListVO> result = Lists.newArrayListWithCapacity(metaData.size());
            metaData.forEach(message -> {
                MessageListVO vo = new MessageListVO();
                BeanUtils.copyProperties(message,vo);
                result.add(vo);
            });
            return result;
        }
        return null;
    }
}
