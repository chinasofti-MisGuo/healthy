package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.AdminRoles;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;

/**
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RolesDTO extends BaseDTO {

    @Min(1)
    private Integer id;

    private String rolesName;

    private String authId;

    public AdminRoles convertToAdminRoles(){
        RolesDtoConvert rolesDtoConvert = new RolesDtoConvert();
        return rolesDtoConvert.doForward(this);
    }

    private static class RolesDtoConvert extends BaseDtoConvert<RolesDTO, AdminRoles>{
        @Override
        protected AdminRoles doForward(RolesDTO rolesDTO) {
            AdminRoles adminRoles = new AdminRoles();
            BeanUtils.copyProperties(rolesDTO, adminRoles);
            return adminRoles;
        }

        @Override
        protected RolesDTO doBackward(AdminRoles adminRoles) {
            return null;
        }
    }

}
