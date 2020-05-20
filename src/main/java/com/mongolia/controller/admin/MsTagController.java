package com.mongolia.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mongolia.exception.InformationErrorException;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.entity.Tag;
import com.mongolia.model.vo.TagVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.model.vo.result.BackPageResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.service.TagService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * 标签管理相关api接口
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/admin/tag")
public class MsTagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public BaseResultVO getTagList(@Valid PageDTO pageDTO) {
        PageInfo<Tag> pageInfo = tagService.getAllList(pageDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), TagVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @GetMapping("/search")
    public BaseResultVO searchList(@Valid SearchDTO searchDTO) {
        PageInfo<Tag> pageInfo = tagService.tagListBySearch(searchDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), TagVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @PostMapping("/add")
    public BaseResultVO addTag(@RequestBody @Valid BaseDataDTO dataDTO){
        if(StringUtils.isEmpty(dataDTO.getTmp()) || Objects.isNull(dataDTO.getFlag())){
            throw new InformationErrorException("参数信息有误");
        }
        Tag tag = new Tag();
        tag.setContent(dataDTO.getTmp());
        tag.setFlag(dataDTO.getFlag());
        boolean result = tagService.addTag(tag);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/edit")
    public BaseResultVO editTag(@RequestBody @Valid BaseDataDTO dataDTO){
        if(Objects.isNull(dataDTO.getId()) || StringUtils.isEmpty(dataDTO.getTmp())){
            throw new InformationErrorException("参数信息有误");
        }
        Tag tag = new Tag();
        tag.setId(dataDTO.getId());
        tag.setContent(dataDTO.getTmp());
        boolean result = tagService.editTag(tag);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/del")
    public BaseResultVO deleteTag(@RequestBody @Valid BaseDataDTO dataDTO){
        if (Objects.isNull(dataDTO.getId())) {
            throw new InformationErrorException("请求参数有误");
        }
        boolean result = tagService.deleteTag(dataDTO.getId());
        return new SuccessResultVO(result ? 1 : 0);
    }

    @GetMapping("/audio/all")
    public BaseResultVO audioTag(@Valid BaseDTO baseDTO){
        List<Tag> tagList = tagService.audioTag();
        List<Object> list = VoFactory.doBackwardList(tagList, TagVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/dynamic/all")
    public BaseResultVO dynamicTag(@Valid BaseDTO baseDTO){
        List<Tag> tagList = tagService.dynamicTag();
        List<Object> list = VoFactory.doBackwardList(tagList, TagVO.class);
        return new SuccessResultVO(list);
    }

}
