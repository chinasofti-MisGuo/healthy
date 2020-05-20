package com.mongolia.service;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Audio;
import com.mongolia.model.entity.AudioDir;
import com.mongolia.model.entity.Comment;

import java.util.Map;

/**
 * 音频相关Service接口
 * @author Dong.w
 */
public interface AudioService {

    /**
     * app端首页推荐音频
     * @param pageDTO   分页数据
     * @return  result list
     */
    PageInfo<AudioDir> getRecommendList(PageDTO pageDTO);

    /**
     * 不同类别音频
     * @param pageDTO   分页数据
     * @param id    分类id
     * @return  result list
     */
    PageInfo<AudioDir> getClassList(PageDTO pageDTO, Integer id);

    /**
     * 目录下的音频列表
     * @param pageDTO 分页数据
     * @return  result list
     */
    PageInfo<Audio> getAudioList(PageDTO pageDTO);

    /**
     * 音频详情页数据
     * @param dataDTO   请求数据
     * @return  result
     */
    Map<String, Object> getAudioDetail(BaseDataDTO dataDTO);

    /**
     * 音频评论数据
     * @param pageDTO   分页数据
     * @param id 音频id
     * @return  result page
     */
    PageInfo<Comment> getCommentList(PageDTO pageDTO, Long id);

    /**
     * 搜索音频
     * @param searchDTO 搜索条件
     * @return  result page
     */
    PageInfo<AudioDir> getSearchList(SearchDTO searchDTO);

    /**
     * 收藏音频目录数据
     * @param pageDTO   分页数据
     * @param uid   用户uid
     * @return  result page
     */
    PageInfo<AudioDir> userCollectList(PageDTO pageDTO, Long uid);

    /**
     * 全部音频目录
     * @param pageDTO   分页信息
     * @return  result page
     */
    PageInfo<AudioDir> audioDirList(PageDTO pageDTO);

    /**
     * 管理系统搜索音频目录
     * @param searchDTO 搜索条件
     * @return  result page
     */
    PageInfo<AudioDir> audioDirListBySearch(SearchDTO searchDTO);

    /**
     * 音频目录点赞
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean likeAudioDir(BaseDataDTO dataDTO);

    /**
     * 音频点赞
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean likeAudio(BaseDataDTO dataDTO);

    /**
     * 评论音频目录
     * @param comment   评论信息
     * @return  result
     */
    boolean commentAudioDir(Comment comment);

    /**
     * 评论音频
     * @param comment   评论信息
     * @return  result
     */
    boolean commentAudio(Comment comment);

    /**
     * 发布音频目录
     * @param audioDir  音频目录数据
     * @return  result
     */
    boolean publishAudioDir(AudioDir audioDir);

    /**
     * 编辑音频目录
     * @param audioDir  数据实体
     * @return  result
     */
    boolean editAudioDir(AudioDir audioDir);

    /**
     * 删除音频目录
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean deleteAudioDir(BaseDataDTO dataDTO);

    /**
     * 发布音频
     * @param audio 音频数据
     * @return  result
     */
    boolean publishAudio(Audio audio);

    /**
     * 编辑音频信息
     * @param audio 音频信息
     * @return  result
     */
    boolean editAudio(Audio audio);

    /**
     * 删除音频信息
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean deleteAudio(BaseDataDTO dataDTO);

    /**
     * 点赞音频目录评论
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean likeDirComment(BaseDataDTO dataDTO);

    /**
     * 点赞音频评论
     * @param dataDTO 请求数据
     * @return  result
     */
    boolean likeComment(BaseDataDTO dataDTO);

    /**
     * 音频目录上下架
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean shelvesAudioDir(BaseDataDTO dataDTO);

    /**
     * 设置音频付费
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean payAudio(BaseDataDTO dataDTO);

    /**
     * 电台目录
     * @param pageDTO   分页数据
     * @return  result page
     */
    PageInfo<AudioDir> radioDirList(PageDTO pageDTO);

    /**
     * 收藏音频目录
     * @param dataDTO   请求数据
     * @return  response result
     */
    boolean collectAudioDir(BaseDataDTO dataDTO);
}
