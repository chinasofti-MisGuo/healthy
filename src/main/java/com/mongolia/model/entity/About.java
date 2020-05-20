package com.mongolia.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 关于我们数据实体
 * @author Dong.w
 */
@Data
public class About implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 电话
     */
    private String phone;

    /**
     * 网址
     */
    private String url;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 功能介绍
     */
    private String function;

    /**
     * 法律声明
     */
    private String legalStatement;

    /**
     * 用户协议
     */
    private String agreement;

    /**
     * 平台使用协议
     */
    private String useAgreement;

    /**
     * 是否删除 0：未删除  1：已删除
     */
    private Short isDel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}