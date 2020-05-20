package com.mongolia.service;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.entity.SetMeal;

import java.util.List;

/**
 * 套餐相关Service接口
 * @author Dong.w
 */
public interface SetMealService {

    /**
     * 套餐列表数据
     * @return  result list
     */
    List<SetMeal> getAllMeal();

    /**
     * 管理系统套餐列表
     * @param pageDTO   分页数据
     * @return  result page
     */
    PageInfo<SetMeal> setMealList(PageDTO pageDTO);

    /**
     * 添加套餐
     * @param setMeal   数据实体
     * @return  result
     */
    boolean addSetMeal(SetMeal setMeal);

    /**
     * 编辑套餐信息
     * @param setMeal   数据实体
     * @return  result
     */
    boolean editSetMeal(SetMeal setMeal);
}
