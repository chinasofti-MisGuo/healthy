package com.mongolia.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.DynamicDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Dynamic;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.vo.DynamicVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.model.vo.result.BackPageResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 动态后台管理相关api接口
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/admin/dynamic")
public class MsDynamicController {

    @Autowired
    private DynamicService dynamicService;

    @GetMapping("/list")
    public BaseResultVO DynamicList(@Valid PageDTO pageDTO) {
        PageInfo<Dynamic> pageInfo = dynamicService.getAllList(pageDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), DynamicVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @GetMapping("/search")
    public BaseResultVO searchDynamic(@Valid SearchDTO searchDTO) {
        PageInfo<Dynamic> pageInfo = dynamicService.backSearchList(searchDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), DynamicVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @GetMapping("/audit")
    public BaseResultVO auditDynamic(@Valid PageDTO pageDTO) {
        PageInfo<Dynamic> pageInfo = dynamicService.auditDynamicList(pageDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), DynamicVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @GetMapping("/audit/search")
    public BaseResultVO audioSearch(@Valid SearchDTO searchDTO){
        PageInfo<Dynamic> pageInfo = dynamicService.auditSearchList(searchDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), DynamicVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @PostMapping("/review")
    public BaseResultVO reviewDynamic(@RequestBody @Valid BaseDataDTO dataDTO){
        boolean result = dynamicService.review(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/edit")
    public BaseResultVO editDynamic(@RequestBody @Valid DynamicDTO dynamicDTO){
        Dynamic dynamic = dynamicDTO.convertTo();
        boolean result = dynamicService.backEditDynamic(dynamic);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/del")
    public BaseResultVO deleteDynamic(@RequestBody @Valid BaseDataDTO dataDTO){
        boolean result = dynamicService.msDeleteDynamic(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/publish")
    public BaseResultVO publishDynamic(@RequestBody @Valid DynamicDTO dynamicDTO){
        Dynamic dynamic = dynamicDTO.convertTo();
        dynamic.setIsPass(StateType.YES.getValue());
        boolean result = dynamicService.publishDynamic(dynamic);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/shelves")
    public BaseResultVO shelvesDynamic(@RequestBody @Valid BaseDataDTO dataDTO){
        boolean result = dynamicService.shelvesDynamic(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/heat")
    public BaseResultVO heatDynamic(@RequestBody @Valid BaseDataDTO dataDTO){
        boolean result = dynamicService.heatDynamic(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/rec")
    public BaseResultVO recommendDynamic(@RequestBody @Valid BaseDataDTO dataDTO){
        boolean result = dynamicService.recommendDynamic(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

}
