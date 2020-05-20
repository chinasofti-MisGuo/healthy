package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * admin_roles
 * @author  Dong.w
 */
@Data
public class AdminRoles implements Serializable {

    private Integer id;

    /**
     * 角色名
     */
    private String rolesName;

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

    private String authId;

}