package com.mongolia.controller.app;

import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.entity.SetMeal;
import com.mongolia.model.vo.SetMealVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.service.SetMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 会员相关API接口
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/app/vip")
public class VipController {

    @Autowired
    private SetMealService setMealService;

    @GetMapping("/list")
    public BaseResultVO setMealList(@Valid BaseDataDTO dataDTO){
        System.out.println("vip");
        List<SetMeal> meals = setMealService.getAllMeal();
        List<Object> list = VoFactory.doBackwardList(meals, SetMealVO.class);
        return new SuccessResultVO(list);
    }

}
