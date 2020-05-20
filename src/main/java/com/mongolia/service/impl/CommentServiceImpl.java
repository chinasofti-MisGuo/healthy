package com.mongolia.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mongolia.dao.CommentMapper;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Comment;
import com.mongolia.model.entity.Favorite;
import com.mongolia.model.enums.FlagType;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.CommentExample;
import com.mongolia.service.CommentService;
import com.mongolia.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 评论相关Service实现
 *
 * @author Dong.w
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private FavoriteService favoriteService;

    @Override
    public Integer getCommentNum(Comment comment) {
        CommentExample commentExample = productionExample(comment);
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andFlagEqualTo(comment.getFlag());
        return commentMapper.countByExample(commentExample);
    }

    @Override
    public Boolean addComment(Comment comment) {
        comment.setCreateTime(new Date());
        int result = commentMapper.insertSelective(comment);
        return (result != 0);
    }

    @Override
    public PageInfo<Comment> getCommentList(PageDTO pageDTO, Comment comment) {
        CommentExample commentExample = productionExample(comment);
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andFlagEqualTo(comment.getFlag());
        criteria.andComIdEqualTo(comment.getComId());
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        setOtherProperty(pageDTO.getUid(),comments);
        return new PageInfo<>(comments);
    }

    @Override
    public PageInfo<Comment> commentList(PageDTO pageDTO) {
        CommentExample commentExample = new CommentExample();
        commentExample.setOrderByClause("id DESC");
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andBaseIdEqualTo((long)StateType.NO.getValue());
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        if (Objects.isNull(comments)) {
            comments = Lists.newArrayList();
        }
        return new PageInfo<>(comments);
    }

    @Override
    public PageInfo<Comment> commentListBySearch(SearchDTO searchDTO) {
        List<Comment> list = commentMapper.selectByCondition(searchDTO);
        if (Objects.isNull(list)) {
            list = Lists.newArrayList();
        }
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<Comment> replyCommentList(PageDTO pageDTO, Long id) {
//        List<Comment> comments = additionalComment(id);
        CommentExample commentExample = new CommentExample();
        commentExample.setOrderByClause("id DESC");
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andBaseIdEqualTo(id);
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        if (Objects.isNull(comments)) {
            comments = Lists.newArrayList();
        }
        return new PageInfo<>(comments);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteComment(Comment comment) {
        Comment del = new Comment();
        del.setIsDel(StateType.YES.getValue());
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andComIdEqualTo(comment.getComId());
        criteria.andFlagEqualTo(comment.getFlag());
        CommentExample.Criteria or = commentExample.or();
        or.andBaseIdEqualTo(comment.getComId());
        commentMapper.updateByExampleSelective(del, commentExample);
        return true;
    }

    @Override
    public boolean deleteCommentByUid(Long uid) {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andUidEqualTo(uid);
        Comment comment = new Comment();
        comment.setIsDel(StateType.YES.getValue());
        int result = commentMapper.updateByExampleSelective(comment, commentExample);
        return (result != 0);
    }

    private List<Comment> additionalComment(Long baseId){
        CommentExample commentExample = new CommentExample();
        commentExample.setOrderByClause("id DESC");
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andBaseIdEqualTo(baseId);
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        return commentMapper.selectByExample(commentExample);
    }

    private CommentExample productionExample(Comment comment) {
        CommentExample commentExample = new CommentExample();
        commentExample.setOrderByClause("id DESC");
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andComIdEqualTo(comment.getComId());
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        return commentExample;
    }

    private void setOtherProperty(Long uid, List<Comment> list) {
        for (Comment comment : list) {
            comment.setCommentList(additionalComment(comment.getId()));
            int likeNum = favoriteService.audioLikeNum(comment.getId());
            int commentNum = getCommentNum(comment);
            final Favorite favorite = new Favorite();
            favorite.setUid(uid);
            favorite.setLikeId(comment.getId());
            favorite.setFlag(FlagType.AUDIO_LIKE.getValue());
            boolean isLike = favoriteService.isLike(favorite);
            comment.setLikeNum(likeNum);
            comment.setIsLike((short)(isLike ? 1 : 0));
            comment.setCommentNum(commentNum);
            for(Comment com : comment.getCommentList()){
                likeNum = favoriteService.audioLikeNum(com.getId());
                favorite.setLikeId(com.getId());
                isLike = favoriteService.isLike(favorite);
                com.setIsLike((short)(isLike?1:0));
                com.setLikeNum(likeNum);
            }
        }
    }

}
