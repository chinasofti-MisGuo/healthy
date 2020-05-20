package com.mongolia.service;

import com.mongolia.model.entity.UserTag;

import java.util.List;

/**
 * 用户兴趣标签Service接口
 * @author Dong.w
 */
public interface UserTagService {

    /**
     * 添加兴趣爱好标签
     * @param userTag   数据实体
     * @return  result
     */
    boolean addHobbyTag(UserTag userTag);

    /**
     * 获取用户兴趣标签
     * @param uid   用户uid
     * @return  result list
     */
    List<Long> TagListByUid(Long uid);
}
