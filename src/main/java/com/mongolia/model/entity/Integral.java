package com.mongolia.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * 积分数据实体
 * @author Dong.w
 */
@Data
public class Integral {
    private Long id;

    private Long uid;

    private Integer score;

    private Short flag;

    private Date createTime;
}