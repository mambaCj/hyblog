package com.mamba.web.http.home;

import com.mamba.service.message.MessageBoardService;
import com.mamba.web.http.BaseController;
import com.mamba.web.http.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Size;

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

    @RequestMapping(value = "/addOneMsg")
    public Result<?> addMessage(@Valid @Size(max = 80) @RequestParam(value = "author",required = false)String author,
                                @Size(max = 400) @RequestParam(value = "content")String content,
                                @RequestParam(value = "pid",defaultValue = "0")Integer pid

    ){
        messageBoardService.addOneMessage(author,content,pid);
        return success();
    }
}
