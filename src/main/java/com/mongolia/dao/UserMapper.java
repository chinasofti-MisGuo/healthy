package com.mongolia.dao;

import com.mongolia.model.entity.User;
import com.mongolia.model.example.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    String selectNikeNameByUid(@Param("uid") Long uid);

    String selectHeadByUid(@Param("uid") Long uid);

    User selectByUid(Long uid);

    String selectPhoneByUid(Long uid);

    List<Long> selectUidLikeNikeName(String nikeName);
}