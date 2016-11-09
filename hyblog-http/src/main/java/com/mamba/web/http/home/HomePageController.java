package com.mamba.web.http.home;

import com.mamba.service.home.HomePageService;
import com.mamba.web.http.BaseController;
import com.mamba.web.http.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mamba_cjh on 2016/11/5.
 */
@RestController
@RequestMapping(value = "/api/home")
public class HomePageController extends BaseController {

    @Autowired
    private HomePageService homePageService;

    @RequestMapping(value = "/index")
    public Result<?> welcomeHome() {
        logger.info("============");
        float ff = 33/0;
        return success();
    }
}
