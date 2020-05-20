package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 标签数据实体
 * @author Dong.w
 */
@Data
public class Tag implements Serializable {

    private Integer id;

    private String content;

    private Short flag;

    private Date createTime;

    private Short isDel;

    private Date updateTime;

}