package com.mongolia.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * integral_rule
 * @author Dong.w
 */
@Data
public class IntegralRule implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 比例 现金:积分
     */
    private String proportion;

    /**
     * 说明
     */
    private String description;

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