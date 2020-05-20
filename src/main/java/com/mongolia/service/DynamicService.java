package com.mongolia.service;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Comment;
import com.mongolia.model.entity.Dynamic;
import com.mongolia.model.entity.Report;
import com.mongolia.model.entity.Tag;

import java.util.List;
import java.util.Map;

/**
 * 动态相关Service接口
 * @author Dong.w
 */
public interface DynamicService {

    /**
     * 推荐动态列表
     * @param pageDTO   分页数据
     * @return  result Page
     */
    PageInfo<Dynamic> getRecommendList(PageDTO pageDTO);

    /**
     * 热门动态列表
     * @param pageDTO   分页数据
     * @return  result Page
     */
    PageInfo<Dynamic> getHeatList(PageDTO pageDTO);

    /**
     * 动态详情
     * @param dataDTO   请求数据
     * @return  result map
     */
    Map<String, Object> getDetail(BaseDataDTO dataDTO);

    /**
     * 全部动态
     * @param pageDTO   分页信息
     * @return  result page
     */
    PageInfo<Dynamic> getAllList(PageDTO pageDTO);

    /**
     * 搜索动态
     * @param searchDTO 搜索条件
     * @return  result list
     */
    PageInfo<Dynamic> searchList(SearchDTO searchDTO);

    /**
     * 所有标签
     * @return  result list
     */
    List<Tag> getAllTag();

    /**
     * 动态评论
     * @param pageDTO   分页数据
     * @param id 动态id
     * @return  result page
     */
    PageInfo<Comment> getCommentList(PageDTO pageDTO, Long id);

    /**
     * 个人主页全部动态数据
     * @param pageDTO   分页数据
     * @param uid   用户uid
     * @return  result Page
     */
    PageInfo<Dynamic> homeAllList(PageDTO pageDTO, Long uid);

    /**
     * 等待审核动态数据
     * @param pageDTO   分页数据
     * @param uid   用户uid
     * @return  result page
     */
    PageInfo<Dynamic> homeWaitList(PageDTO pageDTO, Long uid);

    /**
     * 通过审核动态数据
     * @param pageDTO   分页数据
     * @param uid   用户uid
     * @return  result page
     */
    PageInfo<Dynamic> homePassList(PageDTO pageDTO, Long uid);

    /**
     * 审核未通过数据
     * @param pageDTO   分页数据
     * @param uid   用户uid
     * @return  result page
     */
    PageInfo<Dynamic> homeNotPassList(PageDTO pageDTO, Long uid);

    /**
     * 用户收藏动态
     * @param pageDTO   分页数据
     * @param uid   用户uid
     * @return  result page
     */
    PageInfo<Dynamic> userCollectList(PageDTO pageDTO, Long uid);

    /**
     * 管理系统搜索动态
     * @param searchDTO 搜索条件
     * @return  result page
     */
    PageInfo<Dynamic> backSearchList(SearchDTO searchDTO);

    /**
     * 未审核动态
     * @param pageDTO   分页数据
     * @return  result page
     */
    PageInfo<Dynamic> auditDynamicList(PageDTO pageDTO);

    /**
     * 发布动态
     * @param dynamic   动态数据
     * @return  result
     */
    boolean publishDynamic(Dynamic dynamic);

    /**
     * 评论动态
     * @param comment   评论数据
     * @return  result
     */
    boolean publishComment(Comment comment);

    /**
     * 动态点赞
     * @param dataDTO   点赞数据
     * @return  result
     */
    boolean likeDynamic(BaseDataDTO dataDTO);

    /**
     * 收藏动态
     * @param dataDTO   收藏数据
     * @return  result
     */
    boolean collectDynamic(BaseDataDTO dataDTO);

    /**
     * 动态评论点赞
     * @param dataDTO   数据实体
     * @return  result
     */
    boolean likeComment(BaseDataDTO dataDTO);

    /**
     * 修改动态
     * @param dynamic   动态数据
     * @return  result
     */
    boolean editDynamic(Dynamic dynamic);

    /**
     * 用户删除动态
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean deleteDynamic(BaseDataDTO dataDTO);

    /**
     * 举报动态
     * @param report    举报信息
     * @return  result
     */
    boolean reportDynamic(Report report);

    /**
     * 动态审核
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean review(BaseDataDTO dataDTO);

    /**
     * 动态审核列表搜索
     * @param searchDTO 搜索条件
     * @return  result page
     */
    PageInfo<Dynamic> auditSearchList(SearchDTO searchDTO);

    /**
     * 管理系统删除动态
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean msDeleteDynamic(BaseDataDTO dataDTO);

    /**
     * 动态上下架
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean shelvesDynamic(BaseDataDTO dataDTO);

    /**
     * 发布动态
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean heatDynamic(BaseDataDTO dataDTO);

    /**
     * 推荐动态
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean recommendDynamic(BaseDataDTO dataDTO);

    /**
     * 后台编辑动态
     * @param dynamic   动态实体
     * @return  result
     */
    boolean backEditDynamic(Dynamic dynamic);

    /**
     * 通过uid删除动态
     * @param uid   用户uid
     * @return  result
     */
    boolean deleteDynamicByUid(Long uid);
}
