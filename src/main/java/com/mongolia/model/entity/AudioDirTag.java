package com.mongolia.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 音频标签对应数据实体
 * @author  Dong.w
 */
@Data
public class AudioDirTag implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 目录id
     */
    private Long dirId;

    /**
     * 标签id
     */
    private Integer tagId;

    /**
     * 是否删除  0：未删除  1：已删除
     */
    private Short isDel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}