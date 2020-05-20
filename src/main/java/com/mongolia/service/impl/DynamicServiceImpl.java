package com.mongolia.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mongolia.dao.DynamicMapper;
import com.mongolia.dao.TagMapper;
import com.mongolia.exception.InformationErrorException;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.*;
import com.mongolia.model.enums.FlagType;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.DynamicExample;
import com.mongolia.model.example.TagExample;
import com.mongolia.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 动态相关Service实现
 *
 * @author Dong.w
 */
@Slf4j
@Service
public class DynamicServiceImpl implements DynamicService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private DynamicMapper dynamicMapper;

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private FollowService followService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private UserTagService userTagService;

    @Override
    public PageInfo<Dynamic> getRecommendList(PageDTO pageDTO) {
        log.debug(pageDTO.getUid().toString());
        List<Long> tagList = userTagService.TagListByUid(pageDTO.getUid());
        DynamicExample dynamicExample = new DynamicExample();
        dynamicExample.setOrderByClause("id DESC");
        DynamicExample.Criteria criteria = dynamicExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        if (Objects.nonNull(tagList) && tagList.size() > 0) {
            criteria.andTagIdIn(tagList);
        }
        criteria.andIsRecEqualTo(StateType.YES.getValue());
        criteria.andIsPassEqualTo(StateType.YES.getValue());
        criteria.andIsRelEqualTo(StateType.YES.getValue());
        List<Dynamic> dynamics = dynamicMapper.selectByExample(dynamicExample);
        setOtherProperty(dynamics, pageDTO.getUid());
        return new PageInfo<>(dynamics);
    }

    @Override
    public PageInfo<Dynamic> getHeatList(PageDTO pageDTO) {
        DynamicExample dynamicExample = productionExample();
        DynamicExample.Criteria criteria = dynamicExample.createCriteria();
        criteria.andIsHeatEqualTo(StateType.YES.getValue());
        criteria.andIsPassEqualTo(StateType.YES.getValue());
        criteria.andIsRelEqualTo(StateType.YES.getValue());
        List<Dynamic> dynamics = dynamicMapper.selectByExample(dynamicExample);
        setOtherProperty(dynamics, pageDTO.getUid());
        return new PageInfo<>(dynamics);
    }

    @Override
    public PageInfo<Dynamic> getAllList(PageDTO pageDTO) {
        DynamicExample dynamicExample = productionExample();
        dynamicExample.createCriteria().andIsPassEqualTo(StateType.YES.getValue());
        dynamicExample.createCriteria().andIsRelEqualTo(StateType.YES.getValue());
        List<Dynamic> dynamics = dynamicMapper.selectByExample(dynamicExample);
        setOtherProperty(dynamics, pageDTO.getUid());
        return new PageInfo<>(dynamics);
    }

    @Override
    public Map<String, Object> getDetail(BaseDataDTO dataDTO) {
        Collect collect = new Collect();
        collect.setIsDel(StateType.NO.getValue());
        collect.setCollId((long) dataDTO.getId());
        collect.setUid(dataDTO.getUid());
        collect.setFlag(FlagType.DYNAMIC.getValue());
        boolean collection = collectionService.isCollection(collect);
        boolean userCollect = followService.isFollow(dataDTO.getUid(), dataDTO.getOUid());
        Favorite favorite = new Favorite();
        favorite.setIsDel(StateType.NO.getValue());
        favorite.setFlag(FlagType.DYNAMIC.getValue());
        favorite.setLikeId((long) dataDTO.getId());
        favorite.setUid(dataDTO.getUid());
        boolean isLike = favoriteService.isLike(favorite);
        Map<String, Object> result = new HashMap<>(2);
        result.put("isCollect", collection ? 1 : 0);
        result.put("userCollect", userCollect ? 1 : 0);
        result.put("isLike", isLike ? 1 : 0);
        return result;
    }

    @Override
    public PageInfo<Dynamic> searchList(SearchDTO searchDTO) {
        DynamicExample dynamicExample = new DynamicExample();
        dynamicExample.setOrderByClause("id DESC");
        DynamicExample.Criteria criteria = dynamicExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andTitleLike("%" + searchDTO.getTitle() + "%");
        criteria.andIsPassEqualTo(StateType.YES.getValue());
        List<Dynamic> dynamics = dynamicMapper.selectByExample(dynamicExample);
        setOtherProperty(dynamics, searchDTO.getUid());
        return new PageInfo<>(dynamics);
    }

    @Override
    public List<Tag> getAllTag() {
        TagExample tagExample = new TagExample();
        TagExample.Criteria criteria = tagExample.createCriteria();
        criteria.andFlagEqualTo(FlagType.DYNAMIC.getValue());
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<Tag> tagList = tagMapper.selectByExample(tagExample);
        if (Objects.isNull(tagList)) {
            tagList = Lists.newArrayList();
        }
        return tagList;
    }

    @Override
    public PageInfo<Comment> getCommentList(PageDTO pageDTO, Long id) {
        Comment comment = new Comment();
        comment.setComId(id);
        comment.setFlag(FlagType.DYNAMIC.getValue());
        return commentService.getCommentList(pageDTO, comment);
    }

    @Override
    public PageInfo<Dynamic> homeAllList(PageDTO pageDTO, Long uid) {
        DynamicExample dynamicExample = productionExample();
        DynamicExample.Criteria criteria = dynamicExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andUidEqualTo(uid);
        List<Dynamic> dynamics = dynamicMapper.selectByExample(dynamicExample);
        setOtherProperty(dynamics, uid);
        return new PageInfo<>(dynamics);
    }

    @Override
    public PageInfo<Dynamic> homeWaitList(PageDTO pageDTO, Long uid) {
        DynamicExample dynamicExample = productionExample();
        DynamicExample.Criteria criteria = dynamicExample.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andIsPassEqualTo(StateType.NO.getValue());
        List<Dynamic> dynamics = dynamicMapper.selectByExample(dynamicExample);
        return new PageInfo<>(dynamics);
    }

    @Override
    public PageInfo<Dynamic> homePassList(PageDTO pageDTO, Long uid) {
        DynamicExample dynamicExample = productionExample();
        DynamicExample.Criteria criteria = dynamicExample.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andIsPassEqualTo(StateType.YES.getValue());
        List<Dynamic> dynamics = dynamicMapper.selectByExample(dynamicExample);
        setOtherProperty(dynamics, uid);
        return new PageInfo<>(dynamics);
    }

    @Override
    public PageInfo<Dynamic> homeNotPassList(PageDTO pageDTO, Long uid) {
        DynamicExample dynamicExample = productionExample();
        DynamicExample.Criteria criteria = dynamicExample.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andIsPassEqualTo(StateType.NOT_PASS.getValue());
        List<Dynamic> dynamics = dynamicMapper.selectByExample(dynamicExample);
        return new PageInfo<>(dynamics);
    }

    @Override
    public PageInfo<Dynamic> userCollectList(PageDTO pageDTO, Long uid) {
        List<Dynamic> dynamics = dynamicMapper.selectJoinCollect(uid);
        if (Objects.isNull(dynamics)) {
            dynamics = Lists.newArrayList();
        }
        for (Dynamic dynamic : dynamics) {
            int num = favoriteService.audioDirLikeNum(dynamic.getId());
            dynamic.setLikeNum(num);
            Comment comment = new Comment();
            comment.setComId(dynamic.getId());
            comment.setFlag(FlagType.DYNAMIC.getValue());
            num = commentService.getCommentNum(comment);
            dynamic.setCommentNum(num);
        }
        return new PageInfo<>(dynamics);
    }

    @Override
    public PageInfo<Dynamic> backSearchList(SearchDTO searchDTO) {
        List<Dynamic> list = dynamicMapper.selectBySearchDTO(searchDTO);
        if (Objects.isNull(list)) {
            list = Lists.newArrayList();
        }
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<Dynamic> auditDynamicList(PageDTO pageDTO) {
        DynamicExample dynamicExample = productionExample();
        DynamicExample.Criteria criteria = dynamicExample.createCriteria();
        criteria.andIsPassEqualTo(StateType.NO.getValue());
        List<Dynamic> dynamics = dynamicMapper.selectByExample(dynamicExample);
        if (Objects.isNull(dynamics)) {
            dynamics = Lists.newArrayList();
        }
        return new PageInfo<>(dynamics);
    }

    @Override
    public boolean publishDynamic(Dynamic dynamic) {
        dynamic.setCreateTime(new Date());
        int result = dynamicMapper.insertSelective(dynamic);
        return (result == 1);
    }

    @Override
    public boolean publishComment(Comment comment) {
        comment.setFlag(FlagType.DYNAMIC.getValue());
        comment.setCreateTime(new Date());
        return commentService.addComment(comment);
    }

    @Override
    public boolean likeDynamic(BaseDataDTO dataDTO) {
        Favorite favorite = new Favorite();
        favorite.setLikeId(dataDTO.getId().longValue());
        favorite.setUid(dataDTO.getUid());
        favorite.setFlag(FlagType.DYNAMIC.getValue());
        favorite.setCreateTime(new Date());
        return favoriteService.setLike(favorite);
    }

    @Override
    public boolean collectDynamic(BaseDataDTO dataDTO) {
        Collect collect = new Collect();
        collect.setUid(dataDTO.getUid());
        collect.setCollId(dataDTO.getId().longValue());
        collect.setFlag(FlagType.DYNAMIC.getValue());
        collect.setCreateTime(new Date());
        collect.setIsDel(StateType.NO.getValue());
        return collectionService.collect(collect);
    }

    @Override
    public boolean likeComment(BaseDataDTO dataDTO) {
        Favorite favorite = new Favorite();
        favorite.setLikeId(dataDTO.getId().longValue());
        favorite.setUid(dataDTO.getUid());
        favorite.setFlag(FlagType.DYNAMIC.getValue());
        favorite.setCreateTime(new Date());
        return favoriteService.setLike(favorite);
    }

    @Override
    public boolean editDynamic(Dynamic dynamic) {
        DynamicExample dynamicExample = new DynamicExample();
        DynamicExample.Criteria criteria = dynamicExample.createCriteria();
        criteria.andIsPassEqualTo(StateType.NOT_PASS.getValue());
        criteria.andUidEqualTo(dynamic.getUid());
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andIdEqualTo(dynamic.getId());
        List<Dynamic> dynamics = dynamicMapper.selectByExample(dynamicExample);
        if (Objects.isNull(dynamics) || dynamics.isEmpty()) {
            return false;
        }
        int result = dynamicMapper.updateByPrimaryKeySelective(dynamic);
        return (result == 1);
    }

    @Override
    public boolean deleteDynamic(BaseDataDTO dataDTO) {
        DynamicExample dynamicExample = new DynamicExample();
        DynamicExample.Criteria criteria = dynamicExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andUidEqualTo(dataDTO.getUid());
        criteria.andIdEqualTo(dataDTO.getId().longValue());
        List<Dynamic> dynamics = dynamicMapper.selectByExample(dynamicExample);
        if (Objects.isNull(dynamics) || dynamics.isEmpty()) {
            return false;
        }
        Dynamic dynamic = dynamics.get(0);
        dynamic.setIsDel(StateType.YES.getValue());
        int result = dynamicMapper.updateByPrimaryKeySelective(dynamic);
        Comment comment = new Comment();
        comment.setFlag(FlagType.DYNAMIC.getValue());
        comment.setComId(dynamic.getId());
        boolean delComRes = commentService.deleteComment(comment);
        return (result == 1) && delComRes;
    }

    @Override
    public boolean reportDynamic(Report report) {
        report.setCreateTime(new Date());
        return reportService.addReport(report);
    }

    @Override
    public boolean review(BaseDataDTO dataDTO) {
        Dynamic dynamic = dynamicMapper.selectByPrimaryKey(dataDTO.getId().longValue());
        dynamic.setIsPass(dataDTO.getFlag());
//        if(dataDTO.getFlag() == StateType.YES.getValue()){
//            dynamic.setIsRel(StateType.NO.getValue());
//        }
        dynamic.setExContent(dataDTO.getTmp());
        int result = dynamicMapper.updateByPrimaryKeySelective(dynamic);
        return (result == 1);
    }

    @Override
    public PageInfo<Dynamic> auditSearchList(SearchDTO searchDTO) {
        DynamicExample dynamicExample = productionExample();
        DynamicExample.Criteria criteria = dynamicExample.createCriteria();
        criteria.andIsPassEqualTo(StateType.NO.getValue());
        criteria.andUidEqualTo(searchDTO.getUid());
        List<Dynamic> dynamics = dynamicMapper.selectByExample(dynamicExample);
        return new PageInfo<>(dynamics);
    }

    @Override
    public boolean msDeleteDynamic(BaseDataDTO dataDTO) {
        DynamicExample dynamicExample = new DynamicExample();
        DynamicExample.Criteria criteria = dynamicExample.createCriteria();
        criteria.andIdEqualTo(dataDTO.getId().longValue());
        Dynamic dynamic = new Dynamic();
        dynamic.setIsDel(StateType.YES.getValue());
        int result = dynamicMapper.updateByExampleSelective(dynamic, dynamicExample);
        Comment comment = new Comment();
        comment.setFlag(FlagType.DYNAMIC.getValue());
        comment.setComId(dataDTO.getId().longValue());
        boolean delComRes = commentService.deleteComment(comment);
        return (result == 1) && delComRes;
    }

    @Override
    public boolean shelvesDynamic(BaseDataDTO dataDTO) {
        Dynamic dynamic = dynamicMapper.selectByPrimaryKey(dataDTO.getId().longValue());
        if (Objects.isNull(dynamic)) {
            throw new InformationErrorException("数据不存在");
        }
        if (NumberUtils.compare(dynamic.getIsRel(), StateType.NO.getValue()) == 0) {
            dynamic.setIsRel(StateType.YES.getValue());
        } else if (NumberUtils.compare(dynamic.getIsRel(), StateType.YES.getValue()) == 0) {
            dynamic.setIsRel(StateType.NO.getValue());
        }
        int result = dynamicMapper.updateByPrimaryKeySelective(dynamic);
        return (result == 1);
    }

    @Override
    public boolean heatDynamic(BaseDataDTO dataDTO) {
        Dynamic dynamic = dynamicMapper.selectByPrimaryKey(dataDTO.getId().longValue());
        if (Objects.isNull(dynamic)) {
            throw new InformationErrorException("数据不存在");
        }
        if (NumberUtils.compare(StateType.YES.getValue(), dynamic.getIsHeat()) == 0) {
            dynamic.setIsHeat(StateType.NO.getValue());
        } else if (NumberUtils.compare(StateType.NO.getValue(), dynamic.getIsHeat()) == 0) {
            dynamic.setIsHeat(StateType.YES.getValue());
        }
        int result = dynamicMapper.updateByPrimaryKeySelective(dynamic);
        return (result == 1);
    }

    @Override
    public boolean recommendDynamic(BaseDataDTO dataDTO) {
        Dynamic dynamic = dynamicMapper.selectByPrimaryKey(dataDTO.getId().longValue());
        if (Objects.isNull(dynamic)) {
            throw new InformationErrorException("数据不存在");
        }
        if (NumberUtils.compare(StateType.YES.getValue(), dynamic.getIsRec()) == 0) {
            dynamic.setIsRec(StateType.NO.getValue());
        } else if (NumberUtils.compare(StateType.NO.getValue(), dynamic.getIsRec()) == 0) {
            dynamic.setIsRec(StateType.YES.getValue());
        }
        int result = dynamicMapper.updateByPrimaryKeySelective(dynamic);
        return (result == 1);
    }

    @Override
    public boolean backEditDynamic(Dynamic dynamic) {
        int result = dynamicMapper.updateByPrimaryKeySelective(dynamic);
        return (result == 1);
    }

    @Override
    public boolean deleteDynamicByUid(Long uid) {
        DynamicExample dynamicExample = productionExample();
        dynamicExample.createCriteria().andUidEqualTo(uid);
        Dynamic dynamic = new Dynamic();
        dynamic.setIsDel(StateType.YES.getValue());
        int result = dynamicMapper.updateByExampleSelective(dynamic, dynamicExample);
        return (result != 0);
    }

    private DynamicExample productionExample() {
        DynamicExample dynamicExample = new DynamicExample();
        dynamicExample.setOrderByClause("id DESC");
        DynamicExample.Criteria criteria = dynamicExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        return dynamicExample;
    }

    /**
     * 设置相关属性数据
     *
     * @param list 数据列表
     * @param uid  用户uid
     */
    private void setOtherProperty(List<Dynamic> list, Long uid) {
        for (Dynamic dynamic : list) {
            int likeNum = favoriteService.dynamicLikeNum(dynamic.getId());
            final Comment comment = new Comment();
            comment.setComId(dynamic.getId());
            comment.setFlag(FlagType.DYNAMIC.getValue());
            int commentNum = commentService.getCommentNum(comment);
            Favorite favorite = new Favorite();
            favorite.setUid(uid);
            favorite.setLikeId(dynamic.getId());
            favorite.setFlag(FlagType.DYNAMIC.getValue());
            boolean isLike = favoriteService.isLike(favorite);
            dynamic.setIsLike((short) (isLike ? 1 : 0));
            dynamic.setLikeNum(likeNum);
            dynamic.setCommentNum(commentNum);
        }
    }
}
