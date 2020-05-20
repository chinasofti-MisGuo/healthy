package com.mongolia.dao;

import com.mongolia.model.entity.AdminRolesAuth;

import java.util.List;

public interface AdminRolesAuthMapper {
    int deleteByPrimaryKey(Short id);

    int insert(AdminRolesAuth record);

    int insertSelective(AdminRolesAuth record);

    AdminRolesAuth selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(AdminRolesAuth record);

    int updateByPrimaryKey(AdminRolesAuth record);

    int insertSelectiveList(List<AdminRolesAuth> rolesAuths);

    int deleteByRolesId(Integer id);
}