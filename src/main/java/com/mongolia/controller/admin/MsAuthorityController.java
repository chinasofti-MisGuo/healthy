package com.mongolia.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.AdminUserDTO;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.RolesDTO;
import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.entity.AdminAuth;
import com.mongolia.model.entity.AdminRoles;
import com.mongolia.model.entity.AdminUser;
import com.mongolia.model.vo.AdminUserVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.model.vo.result.BackPageResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Dong.w
 */
@RestController
@RequestMapping("/auth")
public class MsAuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @GetMapping("/all")
    public BaseResultVO authorityList(@Valid BaseDTO baseDTO) {
        List<AdminAuth> list = authorityService.allAuthority();
        return new SuccessResultVO(list);
    }

    @GetMapping("/role/list")
    public BaseResultVO rolesList(@Valid BaseDTO baseDTO) {
        List<AdminRoles> list = authorityService.allRoles();
        return new SuccessResultVO(list);
    }

    @PostMapping("/role/add")
    public BaseResultVO addRoles(@RequestBody @Valid RolesDTO rolesDTO) {
        AdminRoles adminRoles = rolesDTO.convertToAdminRoles();
        boolean result = authorityService.addRoles(adminRoles);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @GetMapping("/role/all")
    public BaseResultVO rolesHavAuth(@Valid BaseDataDTO dataDTO) {
        List<AdminAuth> list = authorityService.rolesHaveAuth(dataDTO);
        return new SuccessResultVO(list);
    }

    @PostMapping("/role/edit")
    public BaseResultVO editRoles(@RequestBody @Valid RolesDTO rolesDTO) {
        AdminRoles adminRoles = rolesDTO.convertToAdminRoles();
        boolean result = authorityService.editRoles(adminRoles);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @PostMapping("/user/add")
    public BaseResultVO addAdminUser(@RequestBody @Valid AdminUserDTO adminUserDTO) {
        AdminUser adminUser = adminUserDTO.convertToAdminUser();
        String result = authorityService.addAdminUser(adminUser);
        return new SuccessResultVO(result);
    }

    @PostMapping("/user/edit")
    public BaseResultVO editAdminUser(@RequestBody @Valid AdminUserDTO adminUserDTO) {
        AdminUser adminUser = adminUserDTO.convertToAdminUser();
        boolean result = authorityService.editAdminUser(adminUser);
        return new SuccessResultVO(result);
    }

    @PostMapping("/user/del")
    public BaseResultVO deleteAdminUser(@RequestBody @Valid BaseDataDTO dataDTO) {
        boolean result = authorityService.deleteAdminUser(dataDTO);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @GetMapping("/user/list")
    public BaseResultVO adminUserList(@Valid PageDTO pageDTO) {
        PageInfo<AdminUser> adminUserPageInfo = authorityService.getAdminUserList(pageDTO);
        List list = VoFactory.doBackwardList(adminUserPageInfo.getList(), AdminUserVO.class);
        return new BackPageResultVO(adminUserPageInfo.getTotal(), list);
    }

}
