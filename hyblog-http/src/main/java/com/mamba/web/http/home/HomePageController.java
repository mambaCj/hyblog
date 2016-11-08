package com.mamba.web.http.home;

import com.mamba.web.http.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mamba_cjh on 2016/11/5.
 */
@RestController
@RequestMapping(value = "/api/home")
public class HomePageController extends BaseController {

    @RequestMapping(value = "/index")
    public Object welcomeHome(){
        logger.info("============");
        return success();
    }
}
