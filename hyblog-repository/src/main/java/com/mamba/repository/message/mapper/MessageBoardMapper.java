package com.mamba.repository.message.mapper;

import com.mamba.repository.message.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mamba on 2017/2/23.
 */
@Repository
public interface MessageBoardMapper {
    List<Message> getFatherMessageList();

    List<Message> getChildrenMessageList(Integer pid);
}
