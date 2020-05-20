package com.mongolia.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mongolia.dao.TagMapper;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Tag;
import com.mongolia.model.enums.FlagType;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.TagExample;
import com.mongolia.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 标签相关实现
 *
 * @author Dong.w
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public PageInfo<Tag> getAllList(PageDTO pageDTO) {
        TagExample tagExample = new TagExample();
        tagExample.setOrderByClause("id DESC");
        TagExample.Criteria criteria = tagExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<Tag> tagList = tagMapper.selectByExample(tagExample);
        if (Objects.isNull(tagList)) {
            tagList = Lists.newArrayList();
        }
        return new PageInfo<>(tagList);
    }

    @Override
    public PageInfo<Tag> tagListBySearch(SearchDTO searchDTO) {
        TagExample tagExample = new TagExample();
        tagExample.setOrderByClause("id DESC");
        TagExample.Criteria criteria = tagExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        if(Objects.nonNull(searchDTO.getTitle())){
            criteria.andContentLike("%" + searchDTO.getTitle() + "%");
        }
        if (Objects.nonNull(searchDTO.getFlag())) {
            criteria.andFlagEqualTo(searchDTO.getFlag());
        }
        List<Tag> tagList = tagMapper.selectByExample(tagExample);
        if (Objects.isNull(tagList)) {
            tagList = Lists.newArrayList();
        }
        return new PageInfo<>(tagList);
    }

    @Override
    public boolean addTag(Tag tag) {
        tag.setCreateTime(new Date());
        int result = tagMapper.insertSelective(tag);
        return (result == 1);
    }

    @Override
    public boolean editTag(Tag tag) {
        tag.setUpdateTime(new Date());
        int result = tagMapper.updateByPrimaryKeySelective(tag);
        return (result == 1);
    }

    @Override
    public boolean deleteTag(Integer id) {
        TagExample tagExample = new TagExample();
        TagExample.Criteria criteria = tagExample.createCriteria();
        criteria.andIdEqualTo(id);
        Tag tag = new Tag();
        tag.setIsDel(StateType.YES.getValue());
        int result = tagMapper.updateByExampleSelective(tag, tagExample);
        return (result == 1);
    }

    @Override
    public List<Tag> audioTag() {
        TagExample tagExample = new TagExample();
        TagExample.Criteria criteria = tagExample.createCriteria();
        criteria.andFlagEqualTo(FlagType.AUDIO.getValue());
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<Tag> tagList = tagMapper.selectByExample(tagExample);
        if (Objects.isNull(tagList)) {
            tagList = Lists.newArrayList();
        }
        return tagList;
    }

    @Override
    public List<Tag> dynamicTag() {
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
}
