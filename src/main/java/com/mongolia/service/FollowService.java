package com.mongolia.service;

import com.mongolia.model.entity.Follow;

import java.util.List;

/**
 * 关注相关Service接口
 * @author Dong.w
 */
public interface FollowService {

    /**
     * 是否关注用户
     * @param uid   用户uid
     * @param oUid  被关注者uid
     * @return  result
     */
    boolean isFollow(Long uid, Long oUid);

    /**
     * 粉丝数量
     * @param uid   用户uid
     * @return  result
     */
    Integer fansNumber(Long uid);

    /**
     * 关注数量
     * @param uid    用户uid
     * @return  result
     */
    Integer attentionNumber(Long uid);

    /**
     * 粉丝列表
     * @param uid   用户uid
     * @return  result list
     */
    List<Follow> getUserFans(Long uid);

    /**
     * 关注列表
     * @param uid   用户uid
     * @return  result list
     */
    List<Follow> getCollect(Long uid);

    /**
     * 关注用户
     * @param follow    关注实体
     * @return  result
     */
    boolean andFollow(Follow follow);
}
