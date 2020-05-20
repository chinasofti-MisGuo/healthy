package com.mongolia.dao;

import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Dynamic;

import java.util.List;

import com.mongolia.model.example.DynamicExample;
import org.apache.ibatis.annotations.Param;

public interface DynamicMapper {
    int countByExample(DynamicExample example);

    int deleteByExample(DynamicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Dynamic record);

    int insertSelective(Dynamic record);

    List<Dynamic> selectByExample(DynamicExample example);

    Dynamic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Dynamic record, @Param("example") DynamicExample example);

    int updateByExample(@Param("record") Dynamic record, @Param("example") DynamicExample example);

    int updateByPrimaryKeySelective(Dynamic record);

    int updateByPrimaryKey(Dynamic record);

    List<Dynamic> selectJoinCollect(Long uid);

    List<Dynamic> selectBySearchDTO(@Param("search") SearchDTO searchDTO);

    String selectTitleById(Long id);
}