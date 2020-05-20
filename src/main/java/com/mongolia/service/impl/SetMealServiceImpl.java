package com.mongolia.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mongolia.dao.SetMealMapper;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.entity.SetMeal;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.SetMealExample;
import com.mongolia.service.SetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 套餐相关Service实现
 * @author Dong.w
 */
@Service
public class SetMealServiceImpl implements SetMealService {

    @Autowired
    private SetMealMapper setMealMapper;

    @Override
    public List<SetMeal> getAllMeal() {
        SetMealExample setMealExample = new SetMealExample();
        SetMealExample.Criteria criteria = setMealExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<SetMeal> meals = setMealMapper.selectByExample(setMealExample);
        if(Objects.isNull(meals)){
            meals = Lists.newArrayList();
        }
        return meals;
    }

    @Override
    public PageInfo<SetMeal> setMealList(PageDTO pageDTO) {
        SetMealExample setMealExample = new SetMealExample();
        setMealExample.setOrderByClause("id DESC");
        SetMealExample.Criteria criteria = setMealExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<SetMeal> meals = setMealMapper.selectByExample(setMealExample);
        if(Objects.isNull(meals)){
            meals = Lists.newArrayList();
        }
        return new PageInfo<>(meals);
    }

    @Override
    public boolean addSetMeal(SetMeal setMeal) {
        setMeal.setCreateTime(new Date());
        int result = setMealMapper.insertSelective(setMeal);
        return (result == 1);
    }

    @Override
    public boolean editSetMeal(SetMeal setMeal) {
        setMeal.setUpdateTime(new Date());
        int result = setMealMapper.updateByPrimaryKeySelective(setMeal);
        return (result == 1);
    }
}
