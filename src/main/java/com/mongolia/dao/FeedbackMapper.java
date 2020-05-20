package com.mongolia.dao;

import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Feedback;

import java.util.List;

/**
 * @author Dong.w
 */
public interface FeedbackMapper {

    /**
     * 通过主键删除
     * @param id    主键id
     * @return  result
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入全部数据
     * @param record    数据实体
     * @return  result
     */
    int insert(Feedback record);

    /**
     * 插入部分数据
     * @param record    数据实体
     * @return  result
     */
    int insertSelective(Feedback record);

    /**
     * 通过主键查询
     * @param id    主键
     * @return  result
     */
    Feedback selectByPrimaryKey(Long id);

    /**
     * 根据主键更新部分数据
     * @param record    数据实体
     * @return  result
     */
    int updateByPrimaryKeySelective(Feedback record);

    /**
     * 根据主键更新全部数据
     * @param record    数据实体
     * @return  result
     */
    int updateByPrimaryKey(Feedback record);

    /**
     * 查询全部数据
     * @return  result
     */
    List<Feedback> selectAll();

    /**
     * 通过条件查询
     * @param searchDTO 查询条件
     * @return  result
     */
    List<Feedback> selectByExample(SearchDTO searchDTO);
}