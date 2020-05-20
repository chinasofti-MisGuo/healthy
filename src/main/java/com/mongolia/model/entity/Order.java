package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单数据实体
 * @author Dong.w
 */
@Data
public class Order implements Serializable {

    private Long id;

    private Long uid;

    private Long setMealId;

    private String orderId;

    private String setMealName;

    private BigDecimal price;

    private Short state;

    private Short payType;

    private Date createTime;

    private Date payTime;

    private Date updateTime;

    private Short isDel;

    private String nikeName;

}