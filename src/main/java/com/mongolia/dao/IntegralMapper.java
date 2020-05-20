package com.mongolia.dao;

import com.mongolia.model.entity.Integral;
import java.util.List;

public interface IntegralMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Integral record);

    Integral selectByPrimaryKey(Long id);

    List<Integral> selectByUid(Long uid);

    List<Integral> selectAll();

    int updateByPrimaryKey(Integral record);

    boolean deleteByUid(Long uid);
}