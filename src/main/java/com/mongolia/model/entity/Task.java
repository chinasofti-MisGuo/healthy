package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 任务数据实体
 * @author Dong.w
 */
@Data
public class Task implements Serializable {

    private Integer id;

    private String name;

    private Integer sort;

    private Integer integral;

    private Integer integralOfDay;

    private String detail;

    private Short isDel;

    private Date createTime;

    private Date updateTime;
}