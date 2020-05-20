package com.mongolia.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Dong.w
 */
public class AdminUserVO {
    private Integer id;

    private String username;

    private Integer radioId;

    private String roles;

    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date loginTime;
}
