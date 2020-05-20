package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 关注用户数据实体
 * @author Dong.w
 */
@Data
public class Follow implements Serializable {

    private Integer id;

    private Long folUid;

    private Long beUid;

    private String nikeName;

    private String headPortrait;

    private Short state;

    private Short isDel;

    private Date createTime;

    private Date updateTime;

}