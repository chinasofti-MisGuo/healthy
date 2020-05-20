package com.mongolia.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 举报数据实体
 * @author Dong.w
 */
@Data
@NoArgsConstructor
public class Report implements Serializable {

    private Long id;

    private String describe;

    private Long dynamicId;

    private Long whistleUid;

    private String dynamicName;

    private String whistleName;

    private Long receiveUid;

    private String receiveName;

    private Integer typeId;

    private String phone;

    private String image;

    private Date createTime;

    private Short isDel;

}