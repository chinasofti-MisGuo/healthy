package com.mongolia.dao;

import com.mongolia.model.entity.Banner;

import java.util.List;

import com.mongolia.model.example.BannerExample;
import org.apache.ibatis.annotations.Param;

/**
 * 轮播图数据操作
 * @author Dong.w
 */
public interface BannerMapper {

    /**
     * 查询数据结果数
     * @param example example
     * @return  result
     */
    int countByExample(BannerExample example);

    /**
     * 删除符合条件的数据
     * @param example   example
     * @return  result
     */
    int deleteByExample(BannerExample example);

    /**
     * 删除数据
     * @param id    id
     * @return  result
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部数据
     * @param record    record
     * @return  result
     */
    int insert(Banner record);

    /**
     * 插入部分数据
     * @param record    record
     * @return  result
     */
    int insertSelective(Banner record);

    /**
     * 查询符合条件的数据
     * @param example   example
     * @return  result
     */
    List<Banner> selectByExample(BannerExample example);

    /**
     * 通过主键查询数据
     * @param id    id
     * @return  result
     */
    Banner selectByPrimaryKey(Integer id);

    /**
     * 更新满足条件的部分数据
     * @param record    record
     * @param example   example
     * @return  result
     */
    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    /**
     * 更新满足条件的数据
     * @param record    record
     * @param example   example
     * @return  result
     */
    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);

    /**
     * 更新部分数据
     * @param record    record
     * @return  result
     */
    int updateByPrimaryKeySelective(Banner record);

    /**
     * 更新全部数据
     * @param record    record
     * @return  result
     */
    int updateByPrimaryKey(Banner record);
}