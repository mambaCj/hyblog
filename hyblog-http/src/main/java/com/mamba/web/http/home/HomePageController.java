package com.mamba.web.http.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mamba_cjh on 2016/11/5.
 */
@RestController
@RequestMapping(value = "/api/home")
public class HomePageController {
    private final static Logger LOGGER = LoggerFactory.getLogger(HomePageController.class);

    @RequestMapping(value = "/index")
    public String welcomeHome(){
        LOGGER.info("============");
System.out.println("55555555555555555555555");
        String test = "welcome...";
        return test;
    }
}
