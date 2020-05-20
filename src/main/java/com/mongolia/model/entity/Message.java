package com.mongolia.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息数据实体
 * @author Dong.w
 */
@Data
public class Message implements Serializable {

    private Long id;

    private String msgTitle;

    private String msgBriefly;

    private String msgContent;

    private Date createTime;

    private Short isDel;

}