package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 动态数据实体
 * @author Dong.w
 */
@Data
public class Dynamic implements Serializable {

    private Long id;

    private Long uid;

    private Long tagId;

    private String image;

    private String title;

    private String content;

    private String author;

    private String audioTime;

    private String artist;

    private Short isHeat;

    private Short isRec;

    private Short isRel;

    private Integer playNum;

    private Short isPass;

    private String exContent;

    private Short isDel;

    private Date createTime;

    private Date updateTime;

    private String nikeName;

    private String headPortrait;

    private Integer likeNum;

    private Integer commentNum;

    private Short isLike;

    private String tagName;

}