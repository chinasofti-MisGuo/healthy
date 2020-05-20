package com.mongolia.dao;

import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Problem;

import java.util.List;

/**
 * Problem Dao
 * @author Dong.w
 */
public interface ProblemMapper {
    /**
     * 通过主键删除
     * @param id    主键
     * @return  result
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据
     * @param record    数据实体
     * @return  result
     */
    int insert(Problem record);

    /**
     * 插入部分数据
     * @param record    数据实体
     * @return  result
     */
    int insertSelective(Problem record);

    /**
     * 通过主键查询
     * @param id    主键
     * @return  result
     */
    Problem selectByPrimaryKey(Integer id);

    /**
     * 更新部分数据
     * @param record    数据实体
     * @return  result
     */
    int updateByPrimaryKeySelective(Problem record);

    /**
     * 更新全部数据
     * @param record    数据实体
     * @return  result
     */
    int updateByPrimaryKey(Problem record);

    /**
     * 查询全部
     * @return  result list
     */
    List<Problem> selectAll();

    /**
     * 按条件查询
     * @param searchDTO 条件
     * @return  result
     */
    List<Problem> selectByExample(SearchDTO searchDTO);
}