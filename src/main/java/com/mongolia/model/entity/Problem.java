package com.mongolia.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 常见问题数据实体
 * @author Dong.w
 */
@Data
public class Problem implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 问题名称
     */
    private String problem;

    /**
     * 答案
     */
    private String answer;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否删除  0：未删除  1：已删除
     */
    private Short isDel;

    private static final long serialVersionUID = 1L;
}