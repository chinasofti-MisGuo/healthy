package com.mongolia.dao;

import com.mongolia.model.entity.Audio;

import java.util.List;

import com.mongolia.model.example.AudioExample;
import org.apache.ibatis.annotations.Param;

public interface AudioMapper {
    int countByExample(AudioExample example);

    int deleteByExample(AudioExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Audio record);

    int insertSelective(Audio record);

    List<Audio> selectByExample(AudioExample example);

    Audio selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Audio record, @Param("example") AudioExample example);

    int updateByExample(@Param("record") Audio record, @Param("example") AudioExample example);

    int updateByPrimaryKeySelective(Audio record);

    int updateByPrimaryKey(Audio record);
}