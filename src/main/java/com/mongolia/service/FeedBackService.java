package com.mongolia.service;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Feedback;

/**
 * 意见反馈相关service
 * @author Dong.w
 */
public interface FeedBackService {
    /**
     * 添加反馈
     * @param feedback  反馈实体
     * @return  result
     */
    int addFeedBack(Feedback feedback);

    /**
     * 获取反馈列表
     * @param pageDTO   分页数据
     * @return  result
     */
    PageInfo<Feedback> getList(PageDTO pageDTO);

    /**
     * 删除反馈信息
     * @param id    标识
     * @return  result
     */
    int deleteFeedBack(Integer id);

    /**
     * 回复反馈
     * @param feedback  数据实体
     * @return  result
     */
    int replyFeedBack(Feedback feedback);

    /**
     * 搜索/筛选数据
     * @param searchDTO 搜索条件
     * @return  result
     */
    PageInfo<Feedback> searchList(SearchDTO searchDTO);
}
