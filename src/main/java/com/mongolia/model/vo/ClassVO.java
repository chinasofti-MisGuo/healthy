package com.mongolia.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 分类数据VO
 * @author Dong.w
 */
@Data
public class ClassVO implements Serializable {

    private Integer id;

    private String className;

    private Integer sort;

    private String title;

    private Short level;

    private Date createTime;

}
