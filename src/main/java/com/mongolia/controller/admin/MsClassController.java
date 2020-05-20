package com.mongolia.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.ClassDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.entity.AudioClass;
import com.mongolia.model.entity.RadioClass;
import com.mongolia.model.vo.ClassVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.model.vo.result.BackPageResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.service.ClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 分类管理相关Api接口
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/admin/class")
public class MsClassController {

    private final Logger logger = LoggerFactory.getLogger(MsClassController.class);

    @Autowired
    private ClassService classService;

    @GetMapping("/audio/list")
    public BaseResultVO audioClassList(@Valid PageDTO pageDTO) {
        PageInfo<AudioClass> pageInfo = classService.audioClassList(pageDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), ClassVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @GetMapping("/radio/list")
    public BaseResultVO radioClassList(@Valid PageDTO pageDTO) {
        PageInfo<RadioClass> pageInfo = classService.radioClassList(pageDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), ClassVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @PostMapping("/audio/add")
    public BaseResultVO addAudioClass(@RequestBody @Valid ClassDTO classDTO) {
        logger.debug(classDTO.toString());
        AudioClass audioClass = classDTO.convertToAudioClass();
        boolean result = classService.addAudioClass(audioClass);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/audio/edit")
    public BaseResultVO editAudioClass(@RequestBody @Valid ClassDTO classDTO) {
        AudioClass audioClass = classDTO.convertToAudioClass();
        boolean result = classService.editAudioClass(audioClass);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/audio/del")
    public BaseResultVO deleteAudioClass(@RequestBody @Valid BaseDataDTO dataDTO) {
        boolean result = classService.deleteAudioClass(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/radio/add")
    public BaseResultVO addRadioClass(@RequestBody @Valid ClassDTO classDTO) {
        RadioClass radioClass = classDTO.convertToRadioClass();
        boolean result = classService.addRadioClass(radioClass);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/radio/edit")
    public BaseResultVO editRadioClass(@RequestBody @Valid ClassDTO classDTO) {
        RadioClass radioClass = classDTO.convertToRadioClass();
        boolean result = classService.editRadioClass(radioClass);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/radio/del")
    public BaseResultVO deleteRadioClass(@RequestBody @Valid BaseDataDTO dataDTO){
        boolean result= classService.deleteRadioClass(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @GetMapping("/audio/sort/{id}")
    public BaseResultVO audioSort(@Valid BaseDTO baseDTO, @PathVariable("id") Integer id){
        List<Integer> list = classService.audioClassSort(id);
        return new SuccessResultVO(list);
    }

    @GetMapping("/radio/sort/{id}")
    public BaseResultVO radioSort(@Valid BaseDataDTO dataDTO, @PathVariable("id") Integer id){
        List<Integer> list = classService.radioClassSort(dataDTO,id);
        return new SuccessResultVO(list);
    }

    @GetMapping("/audio/all")
    public BaseResultVO audioClass(@Valid BaseDTO baseDTO){
        List<AudioClass> audioClassList = classService.audioClass();
        List<Object> list = VoFactory.doBackwardList(audioClassList, ClassVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/radio/all/{id}")
    public BaseResultVO radioClass(@Valid BaseDTO baseDTO, @PathVariable("id") Integer id){
        List<RadioClass> radioClasses = classService.radioClass(id);
        List<Object> list = VoFactory.doBackwardList(radioClasses, ClassVO.class);
        return new SuccessResultVO(list);
    }

}
