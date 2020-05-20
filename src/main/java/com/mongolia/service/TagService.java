package com.mongolia.service;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.AudioDir;
import com.mongolia.model.entity.Tag;

import java.util.List;

/**
 * 标签相关接口
 * @author Dong.w
 */
public interface TagService {

    /**
     * 标签列表
     * @param pageDTO   分页数据
     * @return  result page
     */
    PageInfo<Tag> getAllList(PageDTO pageDTO);

    /**
     * 搜索标签
     * @param searchDTO 搜索条件
     * @return  result page
     */
    PageInfo<Tag> tagListBySearch(SearchDTO searchDTO);

    /**
     * 添加标签
     * @param tag   标签数据实体
     * @return  result
     */
    boolean addTag(Tag tag);

    /**
     * 编辑标签
     * @param tag   标签实体
     * @return  result
     */
    boolean editTag(Tag tag);

    /**
     * 删除标签
     * @param id    标签id
     * @return  result
     */
    boolean deleteTag(Integer id);

    /**
     * 音频全部标签
     * @return  result
     */
    List<Tag> audioTag();

    /**
     * 动态全部标签
     * @return  result
     */
    List<Tag> dynamicTag();

}
