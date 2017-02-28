package com.mamba.service.message;

import com.google.common.collect.Lists;
import com.mamba.repository.message.entity.Message;
import com.mamba.repository.message.mapper.MessageBoardMapper;
import com.mamba.service.message.vo.MessageListVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/**
 * Created by mamba on 2017/2/23.
 */
@Service
public class MessageBoardService {
    private static final Logger logger = LoggerFactory.getLogger(MessageBoardService.class);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
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
}
