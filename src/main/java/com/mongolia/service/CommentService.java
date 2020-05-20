package com.mongolia.service;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Comment;

import java.util.List;

/**
 * 评论相关Service接口
 * @author Dong.w
 */
public interface CommentService {

    /**
     * 获取评论数量
     * @param comment   数据实体
     * @return  result
     */
    Integer getCommentNum(Comment comment);

    /**
     * 添加评论
     * @param comment   数据实体
     * @return  result
     */
    Boolean addComment(Comment comment);

    /**
     * 获取评论列表
     * @param pageDTO   分页数据
     * @param comment   数据实体
     * @return  result
     */
    PageInfo<Comment> getCommentList(PageDTO pageDTO, Comment comment);

    /**
     * 评论数据列表
     * @param pageDTO   分页数据
     * @return  result page
     */
    PageInfo<Comment> commentList(PageDTO pageDTO);

    /**
     * 搜索评论
     * @param searchDTO 搜索条件
     * @return  result page
     */
    PageInfo<Comment> commentListBySearch(SearchDTO searchDTO);

    /**
     * 回复列表
     * @param pageDTO   分页信息
     * @param id    所回复的id
     * @return  result page
     */
    PageInfo<Comment> replyCommentList(PageDTO pageDTO, Long id);

    /**
     * 删除评论
     * @param comment   评论实体
     * @return  result
     */
    boolean deleteComment(Comment comment);

    /**
     * 根据uid删除评论
     * @param uid   用户uid
     * @return  result
     */
    boolean deleteCommentByUid(Long uid);

}
