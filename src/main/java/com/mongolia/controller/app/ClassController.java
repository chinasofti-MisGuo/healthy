package com.mongolia.controller.app;

import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.entity.AudioClass;
import com.mongolia.model.entity.RadioClass;
import com.mongolia.model.vo.ClassVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.service.ClassService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 分类接口相关
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/app/class")
public class ClassController {

    @Resource
    private ClassService classService;

    @GetMapping("/list")
    public BaseResultVO getAudioClassList(){
        List<AudioClass> audioClassList = classService.getIndexClass();
        List list = VoFactory.doBackwardList(audioClassList, ClassVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/radio/list/{id}")
    public BaseResultVO radioClass(@Valid BaseDTO baseDTO, @PathVariable("id") Integer id){
        List<RadioClass> radioClasses = classService.radioClass(id);
        List<Object> list = VoFactory.doBackwardList(radioClasses, ClassVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/audio/list")
    public BaseResultVO audioClass(@Valid BaseDTO baseDTO){
        List<AudioClass> audioClassList = classService.audioClass();
        List<ClassVO> list = VoFactory.doBackwardList(audioClassList, ClassVO.class);
        return new SuccessResultVO(list);
    }
}
