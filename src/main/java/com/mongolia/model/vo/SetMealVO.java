package com.mongolia.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 套餐数据VO
 * @author Dong.w
 */
@Data
public class SetMealVO implements Serializable {

    private Integer id;

    private String logoPath;

    private String name;

    private BigDecimal price;

    private String explain;

    private BigDecimal quota;

}
