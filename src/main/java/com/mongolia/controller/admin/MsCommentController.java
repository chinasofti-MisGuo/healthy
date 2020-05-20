package com.mongolia.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mongolia.exception.InformationErrorException;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Comment;
import com.mongolia.model.vo.CommentVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.model.vo.result.BackPageResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * 管理系统评论相关Api接口
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/admin/comment")
public class MsCommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public BaseResultVO getCommentList(@Valid PageDTO pageDTO) {
        PageInfo<Comment> pageInfo = commentService.commentList(pageDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), CommentVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @GetMapping("/search")
    public BaseResultVO searchComment(@Valid SearchDTO searchDTO) {
        PageInfo<Comment> pageInfo = commentService.commentListBySearch(searchDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), CommentVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @GetMapping("/reply/{id}")
    public BaseResultVO replyComment(@Valid PageDTO pageDTO, @PathVariable("id") Long id) {
        PageInfo<Comment> pageInfo = commentService.replyCommentList(pageDTO, id);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), CommentVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @PostMapping("del")
    public BaseResultVO deleteComment(@Valid BaseDataDTO dataDTO){
        if (Objects.isNull(dataDTO.getId())) {
            throw new InformationErrorException("请求参数有误");
        }
        Comment comment = new Comment();
        comment.setId(dataDTO.getId().longValue());
        boolean result = commentService.deleteComment(comment);
        return new SuccessResultVO(result ? 1 : 0);
    }

}
