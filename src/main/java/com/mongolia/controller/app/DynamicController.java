package com.mongolia.controller.app;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.*;
import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.entity.Comment;
import com.mongolia.model.entity.Dynamic;
import com.mongolia.model.entity.Report;
import com.mongolia.model.entity.Tag;
import com.mongolia.model.vo.CommentVO;
import com.mongolia.model.vo.DynamicVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.model.vo.TagVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.service.DynamicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 动态相关api接口
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/app/dynamic")
public class DynamicController {

    Logger logger = LoggerFactory.getLogger(DynamicController.class);

    @Autowired
    private DynamicService dynamicService;

    @GetMapping("/list/recommend")
    public BaseResultVO getRecommendList(@Valid PageDTO pageDTO) {
        PageInfo<Dynamic> dynamicPageInfo = dynamicService.getRecommendList(pageDTO);
        List list = VoFactory.doBackwardList(dynamicPageInfo.getList(), DynamicVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/list/heat")
    public BaseResultVO getHeatList(@Valid PageDTO pageDTO) {
        PageInfo<Dynamic> dynamicPageInfo = dynamicService.getHeatList(pageDTO);
        List list = VoFactory.doBackwardList(dynamicPageInfo.getList(), DynamicVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/detail")
    public BaseResultVO getDetail(@Valid BaseDataDTO dataDTO) {
        Map<String, Object> result = dynamicService.getDetail(dataDTO);
        return new SuccessResultVO(result);
    }

    @GetMapping("/list/all")
    public BaseResultVO getAllList(@Valid PageDTO pageDTO) {
        PageInfo<Dynamic> dynamicPageInfo = dynamicService.getAllList(pageDTO);
        List list = VoFactory.doBackwardList(dynamicPageInfo.getList(), DynamicVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/search")
    public BaseResultVO searchDynamic(@Valid SearchDTO searchDTO) {
        PageInfo<Dynamic> dynamicPageInfo = dynamicService.searchList(searchDTO);
        List list = VoFactory.doBackwardList(dynamicPageInfo.getList(), DynamicVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/tag")
    public BaseResultVO allTag(@Valid BaseDTO baseDTO) {
        List<Tag> tagList = dynamicService.getAllTag();
        List list = VoFactory.doBackwardList(tagList, TagVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/comment/{id}")
    public BaseResultVO commentList(@Valid PageDTO pageDTO, @PathVariable("id") Long id) {
        PageInfo<Comment> pageInfo = dynamicService.getCommentList(pageDTO, id);
        List list = VoFactory.doBackwardList(pageInfo.getList(), CommentVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/home/all/{uid}")
    public BaseResultVO userHomeAllList(@Valid PageDTO pageDTO, @PathVariable("uid") Long uid) {
        PageInfo<Dynamic> pageInfo = dynamicService.homeAllList(pageDTO, uid);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), DynamicVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/home/wait/{uid}")
    public BaseResultVO userHomeWaitList(@Valid PageDTO pageDTO, @PathVariable("uid") Long uid) {
        PageInfo<Dynamic> pageInfo = dynamicService.homeWaitList(pageDTO, uid);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), DynamicVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/home/pass/{uid}")
    public BaseResultVO userHomePassList(@Valid PageDTO pageDTO, @PathVariable("uid") Long uid) {
        PageInfo<Dynamic> pageInfo = dynamicService.homePassList(pageDTO, uid);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), DynamicVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/home/not/{uid}")
    public BaseResultVO userHomeNotPassList(@Valid PageDTO pageDTO, @PathVariable("uid") Long uid) {
        PageInfo<Dynamic> pageInfo = dynamicService.homeNotPassList(pageDTO, uid);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), DynamicVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/user/collect/{uid}")
    public BaseResultVO userCollectionList(@Valid PageDTO pageDTO, @PathVariable("uid") Long uid) {
        PageInfo<Dynamic> pageInfo = dynamicService.userCollectList(pageDTO, uid);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), DynamicVO.class);
        return new SuccessResultVO(list);
    }

    @GetMapping("/others/{uid}")
    public BaseResultVO othersHomeList(@Valid PageDTO pageDTO, @PathVariable("uid") Long uid) {
        PageInfo<Dynamic> pageInfo = dynamicService.homePassList(pageDTO, uid);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), DynamicVO.class);
        return new SuccessResultVO(list);
    }

    @PostMapping("/publish")
    public BaseResultVO publishDynamic(@RequestBody @Valid DynamicDTO dynamicDTO) {
        Dynamic dynamic = dynamicDTO.convertTo();
        boolean result = dynamicService.publishDynamic(dynamic);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/comment/publish")
    public BaseResultVO publishComment(@RequestBody @Valid CommentDTO commentDTO) {
        Comment comment = commentDTO.convertToComment();
        boolean result = dynamicService.publishComment(comment);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/like")
    public BaseResultVO likeDynamic(@RequestBody @Valid BaseDataDTO dataDTO) {
        boolean result = dynamicService.likeDynamic(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/collect")
    public BaseResultVO collectDynamic(@RequestBody @Valid BaseDataDTO dataDTO) {
        boolean result = dynamicService.collectDynamic(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/comment/like")
    public BaseResultVO likeComment(@RequestBody @Valid BaseDataDTO dataDTO) {
        boolean result = dynamicService.likeComment(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/edit")
    public BaseResultVO editDynamic(@RequestBody @Valid DynamicDTO dynamicDTO) {
        Dynamic dynamic = dynamicDTO.convertTo();
        boolean result = dynamicService.editDynamic(dynamic);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/del")
    public BaseResultVO deleteDynamic(@RequestBody @Valid BaseDataDTO dataDTO) {
        boolean result = dynamicService.deleteDynamic(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/report")
    public BaseResultVO reportDynamic(@RequestBody @Valid ReportDTO reportDTO) {
        Report report = reportDTO.convertToReport();
        boolean result = dynamicService.reportDynamic(report);
        return new SuccessResultVO(result ? 1 : 0);
    }

}