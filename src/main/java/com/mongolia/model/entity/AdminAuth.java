package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * admin_auth
 * @author  Dong.w
 */
@Data
public class AdminAuth implements Serializable {

    private Integer id;

    /**
     * 后台权限名称
     */
    private String authTitle;

    /**
     * 是否删除 0:未删除 1:删除
     */
    private Integer isDel;

    /**
     * 创建时间
     */
    private Date createTime;

}