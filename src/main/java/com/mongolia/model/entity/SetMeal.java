package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 套餐相关数据实体
 * @author Dong.w
 */
@Data
public class SetMeal implements Serializable {

    private Integer id;

    private String logoPath;

    private String name;

    private BigDecimal price;

    private String explain;

    private BigDecimal quota;

    private Date createTime;

    private Date updateTime;

    private Short isDel;

}