package com.mongolia.dao;

import com.mongolia.model.entity.About;

/**
 * 关于我们Dao
 *
 * @author Dong.w
 */
public interface AboutMapper {

    /**
     * 根据主键删除记录
     * @param id    主键
     * @return  result
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部数据
     * @param record    数据实体
     * @return  result
     */
    int insert(About record);

    /**
     * 插入部分数据
     * @param record    数据实体
     * @return  result
     */
    int insertSelective(About record);

    /**
     * 通过主键查询记录
     * @return  result
     */
    About selectByPrimaryKey();

    /**
     * 更新部分数据
     * @param record    数据封装实体
     * @return  result
     */
    int updateByPrimaryKeySelective(About record);

    /**
     * 通过主键更新数据
     * @param record    数据实体
     * @return  result
     */
    int updateByPrimaryKey(About record);

    /**
     * 查询平台使用协议
     * @return result
     */
    String selectUseAreement();
}