package com.mongolia.service;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Message;

/**
 * 消息相关
 *
 * @author Dong.w
 */
public interface MessageService {

    /**
     * 获取消息列表
     * @param pageDTO   分页
     * @return  result
     */
    PageInfo<Message> getList(PageDTO pageDTO);

    /**
     * 添加消息
     * @param message   消息实体
     * @return  result
     */
    int addMessage(Message message);

    /**
     * 搜索消息
     * @param searchDTO 条件
     * @return  result
     */
    PageInfo<Message> getSearchList(SearchDTO searchDTO);
}
