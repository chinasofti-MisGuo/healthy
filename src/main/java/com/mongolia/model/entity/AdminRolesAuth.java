package com.mongolia.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * admin_roles_auth
 * @author 
 */
@Data
public class AdminRolesAuth implements Serializable {
    private Short id;

    /**
     * 角色id
     */
    private Integer rolesId;

    /**
     * 权限id
     */
    private Integer authId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否删除 0:未删除 1:已删除
     */
    private Boolean isDel;

    private static final long serialVersionUID = 1L;
}