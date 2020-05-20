package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.AdminUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;

/**
 * admin user 请求数据实体
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AdminUserDTO extends BaseDTO {

    @Min(1)
    private Integer id;

    private String username;

    private String password;

    @Min(1)
    private Integer radioId;

    @Min(1)
    private Integer rolesId;

    @Length(max = 11,min = 11)
    private String phone;

    public AdminUser convertToAdminUser(){
        AdminDtoConvert adminDtoConvert = new AdminDtoConvert();
        return adminDtoConvert.doForward(this);
    }

    private static class AdminDtoConvert extends BaseDtoConvert<AdminUserDTO, AdminUser>{
        @Override
        protected AdminUser doForward(AdminUserDTO adminUserDTO) {
            AdminUser adminUser = new AdminUser();
            BeanUtils.copyProperties(adminUserDTO, adminUser);
            return adminUser;
        }

        @Override
        protected AdminUserDTO doBackward(AdminUser adminUser) {
            return null;
        }
    }

}
