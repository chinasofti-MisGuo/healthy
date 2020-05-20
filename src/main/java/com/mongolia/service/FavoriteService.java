package com.mongolia.service;

import com.mongolia.model.entity.Favorite;

/**
 * 点赞相关
 * @author Dong.w
 */
public interface FavoriteService {

    /**
     * 音频目录点赞数
     * @param audioDirId    音频目录id
     * @return  result
     */
    Integer audioDirLikeNum(Long audioDirId);

    /**
     * 音频点赞数
     * @param audioId   音频id
     * @return  result
     */
    Integer audioLikeNum(Long audioId);

    /**
     * 动态点赞数
     * @param dynamicId 动态id
     * @return  result
     */
    Integer dynamicLikeNum(Long dynamicId);

    /**
     * 评论点赞数
     * @param commentId 评论id
     * @return  result
     */
    Integer commentLikeNum(Long commentId);

    /**
     * 是否点赞
     * @param favorite 数据实体
     * @return  result
     */
    Boolean isLike(Favorite favorite);

    /**
     * 点赞
     * @param favorite 数据实体
     * @return  result
     */
    Boolean setLike(Favorite favorite);

}
