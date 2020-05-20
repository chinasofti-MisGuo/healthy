package com.mongolia.dao;

import com.mongolia.model.entity.AudioClass;
import com.mongolia.model.example.AudioClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AudioClassMapper {
    int countByExample(AudioClassExample example);

    int deleteByExample(AudioClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AudioClass record);

    int insertSelective(AudioClass record);

    List<AudioClass> selectByExample(AudioClassExample example);

    AudioClass selectByPrimaryKey(Integer id);

    String selectNameByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AudioClass record, @Param("example") AudioClassExample example);

    int updateByExample(@Param("record") AudioClass record, @Param("example") AudioClassExample example);

    int updateByPrimaryKeySelective(AudioClass record);

    int updateByPrimaryKey(AudioClass record);
}