package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * admin_user
 * @author 
 */
@Data
public class AdminUser implements Serializable {
    private Integer id;

    /**
     * 管理员的姓名
     */
    private String username;

    /**
     * 登录账号
     */
    private String adminUid;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 电台目录id
     */
    private Integer radioId;

    /**
     * 角色id
     */
    private Integer rolesId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 登录凭证
     */
    private String token;

    /**
     * 最后登录时间
     */
    private Date loginTime;

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

    private String roles;

    private static final long serialVersionUID = 1L;
}