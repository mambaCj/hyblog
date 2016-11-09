package com.mamba.service.home;

import com.mamba.repository.home.mapper.HomePageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mamba on 2016/11/9.
 */
@Service
public class HomePageService {

    private static final Logger logger = LoggerFactory.getLogger(HomePageService.class);

    @Autowired
    private HomePageMapper homePageMapper;
}
