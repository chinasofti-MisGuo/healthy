package com.mongolia.model.entity;

import lombok.Data;

import javax.enterprise.inject.Default;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 点赞数据实体
 * @author Dong.w
 */
@Data
public class Favorite {

    private Long id;

    @NotNull
    @Min(1)
    private Long likeId;

    @NotNull
    @Min(1)
    private Long uid;

    @NotNull
    @Min(1)
    @Max(5)
    private Short flag;

    private Short isDel;

    private Date createTime;

    private Date updateTime;

}