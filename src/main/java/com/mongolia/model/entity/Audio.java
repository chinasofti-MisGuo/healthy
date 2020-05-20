package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 音频数据实体
 * @author Dong.w
 */
@Data
public class Audio implements Serializable {

    private Long id;

    private Long dirId;

    private String title;

    private String introduce;

    private String image;

    private String audioPath;

    private String lrcPath;

    private Short ifPay;

    private String audioTime;

    private Short isDel;

    private Date createTime;

    private Date updateTime;

}