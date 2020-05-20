package com.mongolia.dao;

import com.mongolia.model.entity.RadioClass;
import com.mongolia.model.example.RadioClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RadioClassMapper {
    int countByExample(RadioClassExample example);

    int deleteByExample(RadioClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RadioClass record);

    int insertSelective(RadioClass record);

    List<RadioClass> selectByExample(RadioClassExample example);

    RadioClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RadioClass record, @Param("example") RadioClassExample example);

    int updateByExample(@Param("record") RadioClass record, @Param("example") RadioClassExample example);

    int updateByPrimaryKeySelective(RadioClass record);

    int updateByPrimaryKey(RadioClass record);
}