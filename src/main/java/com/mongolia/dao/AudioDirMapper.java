package com.mongolia.dao;

import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.AudioDir;
import com.mongolia.model.example.AudioDirExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AudioDirMapper {
    int countByExample(AudioDirExample example);

    int deleteByExample(AudioDirExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AudioDir record);

    int insertSelective(AudioDir record);

    List<AudioDir> selectByExample(AudioDirExample example);

    AudioDir selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AudioDir record, @Param("example") AudioDirExample example);

    int updateByExample(@Param("record") AudioDir record, @Param("example") AudioDirExample example);

    int updateByPrimaryKeySelective(AudioDir record);

    int updateByPrimaryKey(AudioDir record);

    List<AudioDir> selectJoinCollect(Long uid);

}