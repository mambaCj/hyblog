package com.mamba.service.message.vo;


import com.mamba.repository.message.entity.Message;

import java.util.List;

/**
 * Created by mamba on 2017/2/23.
 */
public class MessageListVO{
    private Integer id;

    private String content;

    private String author;

    private String createTime;

    private List<Message> subMessages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<Message> getSubMessages() {
        return subMessages;
    }

    public void setSubMessages(List<Message> subMessages) {
        this.subMessages = subMessages;
    }
}
