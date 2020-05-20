package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 轮播图数据实体
 * @author Dong.w
 */
@Data
public class Banner implements Serializable {
    private Integer id;

    private String imgName;

    private String imgTitle;

    private Short imgState;

    private String imgAddress;

    private String imgUrl;

    private Integer imgSort;

    private Date createTime;

    private Date updateTime;

    private Short isDel;
}