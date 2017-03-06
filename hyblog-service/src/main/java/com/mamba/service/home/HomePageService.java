package com.mamba.service.home;

import com.google.common.collect.Lists;
import com.mamba.repository.home.entity.BlogDetail;
import com.mamba.repository.home.mapper.BlogDetailMapper;
import com.mamba.service.home.vo.BlogDetailVO;
import com.mamba.service.home.vo.ReadRankingVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * Created by mamba on 2016/11/9.
 */
@Service
public class HomePageService {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final Logger logger = LoggerFactory.getLogger(HomePageService.class);

    @Autowired
    private BlogDetailMapper blogDetailMapper;

    public List<BlogDetailVO> getBlogList(){
        List<BlogDetail> metaData = blogDetailMapper.getBlogList();
        if(CollectionUtils.isNotEmpty(metaData)){
            List<BlogDetailVO> result = Lists.newArrayListWithCapacity(metaData.size());
            for(BlogDetail blogDetail : metaData){
                final BlogDetailVO vo = new BlogDetailVO();
                BeanUtils.copyProperties(blogDetail,vo);
                vo.setPublishTime(blogDetail.getPublishTime().format(DATE_TIME_FORMATTER));
                result.add(vo);
            }
            return result;
        }
        return Lists.newArrayList();
    }

    public void addReadCount(Integer id) {
        blogDetailMapper.addReadCount(id);
    }

    public List<ReadRankingVO> rankReading() {
        List<BlogDetail> metaData = blogDetailMapper.rankReading();
        if(CollectionUtils.isNotEmpty(metaData)){
            List<ReadRankingVO> result = Lists.newArrayListWithCapacity(metaData.size());
            metaData.forEach(blogDetail -> {
                ReadRankingVO vo = new ReadRankingVO();
                BeanUtils.copyProperties(blogDetail,vo);
                result.add(vo);
            });
            return result;
        }
        return Lists.newArrayList();
    }
}
