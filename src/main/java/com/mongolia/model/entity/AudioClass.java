package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 音频分类数据实体
 * @author Dong.w
 */
@Data
public class AudioClass implements Serializable {
    private Integer id;

    private String className;

    private Integer sort;

    private Short isDel;

    private Date createTime;

    private Date updateTime;

}