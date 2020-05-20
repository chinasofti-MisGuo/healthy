package com.mongolia.service;

import com.mongolia.model.entity.Collect;

/**
 * 收藏相关Service
 * @author Dong.w
 */
public interface CollectionService {

    /**
     * 检查是否收藏
     * @param collection    数据实体
     * @return  result
     */
    Boolean isCollection(Collect collection);

    /**
     * 添加/取消收藏
     * @param collection    数据实体
     * @return  result
     */
    Boolean collect(Collect collection);

    /**
     * 删除收藏
     * @param uid   用户uid
     * @return  result
     */
    boolean deleteCollect(Long uid);
}
