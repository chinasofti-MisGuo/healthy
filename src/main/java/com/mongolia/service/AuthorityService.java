package com.mongolia.service;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.entity.AdminAuth;
import com.mongolia.model.entity.AdminRoles;
import com.mongolia.model.entity.AdminUser;

import java.util.List;

/**
 * 管理系统权限Service接口
 * @author Dong.w
 */
public interface AuthorityService {

    /**
     * 所有权限
     * @return  list
     */
    List<AdminAuth> allAuthority();

    /**
     * 所有角色
     * @return  list
     */
    List<AdminRoles> allRoles();

    /**
     * 添加角色
     * @param adminRoles    角色数据实体
     * @return  boolean
     */
    boolean addRoles(AdminRoles adminRoles);

    /**
     * 角色拥有的权限
     * @param dataDTO   请求数据
     * @return  list
     */
    List<AdminAuth> rolesHaveAuth(BaseDataDTO dataDTO);

    /**
     * 编辑角色
     * @param adminRoles    角色实体
     * @return  boolean
     */
    boolean editRoles(AdminRoles adminRoles);

    /**
     * 添加管理员
     * @param adminUser 管理员数据
     * @return  admin uid
     */
    String addAdminUser(AdminUser adminUser);

    /**
     * 编辑管理员
     * @param adminUser 管理员数据
     * @return  boolean
     */
    boolean editAdminUser(AdminUser adminUser);

    /**
     * 删除管理员
     * @param dataDTO   请求数据
     * @return  result
     */
    boolean deleteAdminUser(BaseDataDTO dataDTO);

    /**
     * 管理员列表
     * @param pageDTO   分页信息
     * @return  page
     */
    PageInfo<AdminUser> getAdminUserList(PageDTO pageDTO);
}
