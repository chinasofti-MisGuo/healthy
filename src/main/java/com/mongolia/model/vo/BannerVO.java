package com.mongolia.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 轮播图回传数据
 *
 * @author Dong.w
 */
@Data
public class BannerVO implements Serializable {

    private Integer id;

    private Short imgState;

    private String imgName;

    private String imgTitle;

    private String imgUrl;

    private String imgAddress;

    private Integer imgSort;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
