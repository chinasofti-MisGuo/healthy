package com.mongolia.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单响应数据实体
 * @author Dong.w
 */
@Data
public class OrderVO implements Serializable {
    private Long id;

    private Long uid;

    private Long setMealId;

    private String orderId;

    private String setMealName;

    private BigDecimal price;

    private Short state;

    private Short payType;

    private String nikeName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date payTime;
}
