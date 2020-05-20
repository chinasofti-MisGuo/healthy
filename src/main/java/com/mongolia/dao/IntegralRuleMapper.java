package com.mongolia.dao;

import com.mongolia.model.entity.IntegralRule;

public interface IntegralRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IntegralRule record);

    int insertSelective(IntegralRule record);

    IntegralRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IntegralRule record);

    int updateByPrimaryKey(IntegralRule record);
}