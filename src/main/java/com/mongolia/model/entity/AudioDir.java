package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 音频目录数据实体
 * @author Dong.w
 */
@Data
public class AudioDir implements Serializable {

    private Long id;

    private Integer classId;

    private String title;

    private String introduce;

    private String imagePath;

    private BigDecimal price;

    private Short flag;

    private Short ifRel;

    private Short ifRec;

    private Short isDel;

    private Date createTime;

    private Date updateTime;

    private List<Tag> tagList = new ArrayList<>();

    private String tag;

    private String clazzName;

    private Integer likeNum;

    private Integer commentNum;

    private Integer playNum;
}