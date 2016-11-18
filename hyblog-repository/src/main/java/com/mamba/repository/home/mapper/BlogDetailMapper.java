package com.mamba.repository.home.mapper;

import com.mamba.repository.home.entity.BlogDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mamba on 2016/11/9.
 */
@Repository
public interface BlogDetailMapper {

    List<BlogDetail> getBlogList();

    void addReadCount(Integer id);
}
