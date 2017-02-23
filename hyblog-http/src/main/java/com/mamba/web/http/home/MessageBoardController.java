package com.mamba.web.http.home;

import com.mamba.service.message.MessageBoardService;
import com.mamba.web.http.BaseController;
import com.mamba.web.http.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mamba on 2017/2/23.
 */
@RestController
@RequestMapping(value = "/api/message")
public class MessageBoardController extends BaseController {

    @Autowired
    private MessageBoardService messageBoardService;

    @RequestMapping(value = "/list")
    public Result<?> getMessageList(){
        return success(messageBoardService.getMessageList());
    }
}
