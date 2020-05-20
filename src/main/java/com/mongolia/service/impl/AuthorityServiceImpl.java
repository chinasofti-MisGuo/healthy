package com.mongolia.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mongolia.dao.AdminAuthMapper;
import com.mongolia.dao.AdminRolesAuthMapper;
import com.mongolia.dao.AdminRolesMapper;
import com.mongolia.dao.AdminUserMapper;
import com.mongolia.exception.InformationErrorException;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.entity.AdminAuth;
import com.mongolia.model.entity.AdminRoles;
import com.mongolia.model.entity.AdminRolesAuth;
import com.mongolia.model.entity.AdminUser;
import com.mongolia.service.AuthorityService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 管理系统权限Service实现
 *
 * @author Dong.w
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private AdminAuthMapper adminAuthMapper;

    @Autowired
    private AdminRolesMapper adminRolesMapper;

    @Autowired
    private AdminRolesAuthMapper adminRolesAuthMapper;

    @Override
    public List<AdminAuth> allAuthority() {
        List<AdminAuth> list = adminAuthMapper.selectAllAuth();
        if (CollectionUtil.isEmpty(list)) {
            list = Lists.newArrayList();
        }
        return list;
    }

    @Override
    public List<AdminRoles> allRoles() {
        List<AdminRoles> list = adminRolesMapper.selectListRoles();
        if (CollectionUtil.isEmpty(list)) {
            list = Lists.newArrayList();
        }
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addRoles(AdminRoles adminRoles) {
        adminRoles.setCreateTime(new Date());
        int result = adminRolesMapper.insertSelective(adminRoles);
        String[] auth = adminRoles.getAuthId().split(",");
        List<AdminRolesAuth> rolesAuths = Lists.newArrayList();
        for (String authId : auth) {
            AdminRolesAuth adminRolesAuth = new AdminRolesAuth();
            adminRolesAuth.setAuthId(Integer.valueOf(authId));
            adminRolesAuth.setRolesId(adminRoles.getId());
            rolesAuths.add(adminRolesAuth);
        }
        int rolesResult = adminRolesAuthMapper.insertSelectiveList(rolesAuths);
        return (result != 0 && rolesResult != 0);
    }

    @Override
    public List<AdminAuth> rolesHaveAuth(BaseDataDTO dataDTO) {
        List<AdminAuth> list = adminAuthMapper.selectRolesAuth(dataDTO.getId());
        if (CollectionUtil.isEmpty(list)) {
            list = Lists.newArrayList();
        }
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean editRoles(AdminRoles adminRoles) {
        adminRoles.setUpdateTime(new Date());
        int result = adminRolesMapper.updateByPrimaryKeySelective(adminRoles);
        if (StringUtils.isEmpty(adminRoles.getAuthId())) {
            adminRolesAuthMapper.deleteByRolesId(adminRoles.getId());
            String[] auth = adminRoles.getAuthId().split(",");
            List<AdminRolesAuth> list = Lists.newArrayList();
            for (String authId : auth) {
                AdminRolesAuth adminRolesAuth = new AdminRolesAuth();
                adminRolesAuth.setCreateTime(new Date());
                adminRolesAuth.setRolesId(adminRoles.getId());
                adminRolesAuth.setAuthId(Integer.valueOf(authId));
                list.add(adminRolesAuth);
            }
            int authResult = adminRolesAuthMapper.insertSelectiveList(list);
            return (result != 0 && authResult != 0);
        }
        return (result != 0);
    }

    @Override
    public String addAdminUser(AdminUser adminUser) {
        adminUser.setAdminUid(generateAdminUid());
        adminUser.setCreateTime(new Date());
        int result = adminUserMapper.insertSelective(adminUser);
        if (result != 0) {
            return adminUser.getAdminUid();
        } else {
            return null;
        }
    }

    @Override
    public boolean editAdminUser(AdminUser adminUser) {
        adminUser.setUpdateTime(new Date());
        int result = adminUserMapper.updateByPrimaryKeySelective(adminUser);
        return (result != 0);
    }

    @Override
    public boolean deleteAdminUser(BaseDataDTO dataDTO) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(dataDTO.getId());
        if(Objects.isNull(adminUser)){
            throw new InformationErrorException("用户不存在");
        }
        adminUser.setIsDel(true);
        int result = adminUserMapper.updateByPrimaryKeySelective(adminUser);
        return (result != 0);
    }

    @Override
    public PageInfo<AdminUser> getAdminUserList(PageDTO pageDTO) {
        List<AdminUser> list = adminUserMapper.selectUserList();
        if (CollectionUtil.isEmpty(list)) {
            list = Lists.newArrayList();
        }
        return new PageInfo<>(list);
    }

    private String generateAdminUid() {
        String result = null;
        while (true) {
            result = RandomStringUtils.randomAlphanumeric(5);
            int count = adminUserMapper.selectCountByAdminUid(result);
            if (count == 0) {
                break;
            }
        }
        return result;
    }
}
