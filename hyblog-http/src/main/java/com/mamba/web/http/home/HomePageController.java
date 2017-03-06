package com.mamba.web.http.home;

import com.mamba.repository.message.mapper.MessageBoardMapper;
import com.mamba.service.home.HomePageService;
import com.mamba.service.home.vo.BlogDetailVO;
import com.mamba.service.home.vo.ReadRankingVO;
import com.mamba.service.message.MessageBoardService;
import com.mamba.service.message.vo.MessageListVO;
import com.mamba.web.http.BaseController;
import com.mamba.web.http.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mamba_cjh on 2016/11/5.
 */
@RestController
@RequestMapping(value = "/api/home")
public class HomePageController extends BaseController {

    @Autowired
    private HomePageService homePageService;

    @Autowired
    private MessageBoardService messageBoardService;

    @RequestMapping(value = "/index")
    public Result<?> welcomeHome() {
        List<BlogDetailVO> result = homePageService.getBlogList();
        logger.debug("============list.size={}",result.size());
        return success(result);
    }

    @RequestMapping(value = "/read")
    public Result<?> readStatistic(@RequestParam Integer id){
        logger.info("begin to add read count...blogId={}",id);
        homePageService.addReadCount(id);
        return success();
    }

    @RequestMapping(value = "/readRanking")
    public Result<?> getReadRanking(){
        return success(homePageService.rankReading());
    }

    @RequestMapping(value = "/latestMsg")
    public Result<?> getLatestMessage(){
        return success(messageBoardService.getLatestMessages());
    }
}
