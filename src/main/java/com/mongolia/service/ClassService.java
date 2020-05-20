package com.mongolia.service;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.entity.AudioClass;
import com.mongolia.model.entity.RadioClass;

import java.util.List;

/**
 * 分类相关Service接口
 * @author Dong.w
 */
public interface ClassService {

    /**
     * app首页分类
     * @return result list
     */
    List<AudioClass> getIndexClass();

    /**
     * 音频分类
     * @param pageDTO 分页信息
     * @return  result page
     */
    PageInfo<AudioClass> audioClassList(PageDTO pageDTO);

    /**
     * 电台分类
     * @param pageDTO   分页信息
     * @return  result page
     */
    PageInfo<RadioClass> radioClassList(PageDTO pageDTO);

    /**
     * 添加音频分类
     * @param audioClass    分类信息
     * @return  result
     */
    boolean addAudioClass(AudioClass audioClass);

    /**
     * 编辑音频分类
     * @param audioClass    分类信息
     * @return  result
     */
    boolean editAudioClass(AudioClass audioClass);

    /**
     * 删除音频分类
     * @param dataDTO   分类信息
     * @return  result
     */
    boolean deleteAudioClass(BaseDataDTO dataDTO);

    /**
     * 添加电台分类
     * @param radioClass    电台分类信息
     * @return  result
     */
    boolean addRadioClass(RadioClass radioClass);

    /**
     * 编辑电台分类
     * @param radioClass    分类信息
     * @return  result
     */
    boolean editRadioClass(RadioClass radioClass);

    /**
     * 删除电台分类
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean deleteRadioClass(BaseDataDTO dataDTO);

    /**
     * 音频分类已存在排序
     * @param id    分类id（为空时显示全部数据）
     * @return      result list
     */
    List<Integer> audioClassSort(Integer id);

    /**
     * 电台分类已存在排序
     * @param dataDTO   分类id
     * @param id    等级id
     * @return
     */
    List<Integer> radioClassSort(BaseDataDTO dataDTO, Integer id);

    /**
     * 音频分类列表
     * @return  list
     */
    List<AudioClass> audioClass();

    /**
     * 电台分类列表
     * @param id 父类id
     * @return result
     */
    List<RadioClass> radioClass(Integer id);
}
