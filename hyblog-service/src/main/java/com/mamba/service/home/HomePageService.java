package com.mamba.service.home;

import com.mamba.repository.home.entity.BlogDetail;
import com.mamba.repository.home.mapper.BlogDetailMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mamba on 2016/11/9.
 */
@Service
public class HomePageService {

    private static final Logger logger = LoggerFactory.getLogger(HomePageService.class);

    @Autowired
    private BlogDetailMapper blogDetailMapper;

    public List<BlogDetail> getBlogList(){
        return blogDetailMapper.getBlogList();
    }
}
