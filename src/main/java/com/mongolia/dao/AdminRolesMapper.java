package com.mongolia.dao;

import com.mongolia.model.entity.AdminRoles;

import java.util.List;

public interface AdminRolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminRoles record);

    int insertSelective(AdminRoles record);

    AdminRoles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminRoles record);

    int updateByPrimaryKey(AdminRoles record);

    List<AdminRoles> selectListRoles();

    String selectRoleNameById(Integer id);
}