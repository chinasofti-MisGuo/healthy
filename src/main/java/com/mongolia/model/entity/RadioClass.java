package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 电台分类数据实体
 * @author Dong.w
 */
@Data
public class RadioClass implements Serializable {

    private Integer id;

    private String title;

    private Integer baseId;

    private Short level;

    private Integer sort;

    private Short isDel;

    private Date createTime;

    private Date updateTime;

}