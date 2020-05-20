package com.mongolia.dao;

import com.mongolia.model.entity.AudioDirTag;

public interface AudioDirTagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AudioDirTag record);

    int insertSelective(AudioDirTag record);

    AudioDirTag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AudioDirTag record);

    int updateByPrimaryKey(AudioDirTag record);

    int deleteByDirId(Long id);
}