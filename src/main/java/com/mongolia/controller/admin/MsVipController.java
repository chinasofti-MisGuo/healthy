package com.mongolia.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SetMealDTO;
import com.mongolia.model.entity.SetMeal;
import com.mongolia.model.vo.SetMealVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.model.vo.result.BackPageResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.service.SetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 管理系统vip管理相关api接口
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/admin/vip")
public class MsVipController {

    @Autowired
    private SetMealService setMealService;

    @GetMapping("/list")
    public BaseResultVO vipList(@Valid PageDTO pageDTO){
        PageInfo<SetMeal> pageInfo = setMealService.setMealList(pageDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), SetMealVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @PostMapping("/add")
    public BaseResultVO addSetMeal(@RequestBody @Valid SetMealDTO setMealDTO){
        SetMeal setMeal = setMealDTO.convertToSetMeal();
        boolean result = setMealService.addSetMeal(setMeal);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/edit")
    public BaseResultVO editSetMeal(@RequestBody @Valid SetMealDTO setMealDTO){
        SetMeal setMeal = setMealDTO.convertToSetMeal();
        boolean result = setMealService.editSetMeal(setMeal);
        return new SuccessResultVO(result ? 1 : 0);
    }

}
