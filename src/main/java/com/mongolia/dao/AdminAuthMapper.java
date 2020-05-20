package com.mongolia.dao;

import com.mongolia.model.entity.AdminAuth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminAuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminAuth record);

    int insertSelective(AdminAuth record);

    AdminAuth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminAuth record);

    int updateByPrimaryKey(AdminAuth record);

    List<AdminAuth> selectAllAuth();

    List<AdminAuth> selectRolesAuth(Integer id);
}