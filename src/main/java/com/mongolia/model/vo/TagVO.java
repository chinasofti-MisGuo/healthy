package com.mongolia.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 标签数据VO
 * @author Dong.w
 */
@Data
public class TagVO implements Serializable {

    private Integer id;

    private String content;

    private Short flag;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
