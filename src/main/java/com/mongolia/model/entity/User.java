package com.mongolia.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户数据实体
 * @author Dong.w
 */
@Data
public class User {

    private Long id;

    private Long uid;

    private String phone;

    private String nickname;

    private String password;

    private String wechatId;

    private String qq;

    private String fullname;

    private String idNumber;

    private String idCardImg;

    private Short sex;

    private String city;

    private String birthday;

    private String profile;

    private String headPortrait;

    private Short age;

    private Short isVip;

    private Date vipDueTime;

    private Short isDel;

    private Short state;

    private Short comState;

    private Short auditState;

    private String token;

    private Date loginTime;

    private Date createTime;

    private Date updateTime;

    private String exContent;

}