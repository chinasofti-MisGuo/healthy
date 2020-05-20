package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 收藏数据实体
 * @author Dong.w
 */
@Data
public class Collect implements Serializable {

    private Long id;

    private Long collId;

    private Long uid;

    private Short flag;

    private Short isDel;

    private Date createTime;

    private Date updateTime;

}