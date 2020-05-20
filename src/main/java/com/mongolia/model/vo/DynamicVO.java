package com.mongolia.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 动态数据VO
 * @author Dong.w
 */
@Data
public class DynamicVO implements Serializable {

    private Long id;

    private Long uid;

    private Long tagId;

    private String image;

    private String title;

    private String content;

    private String author;

    private String artist;

    private String audioTime;

    private Short isHeat;

    private Short isRec;

    private Short isRel;

    private Integer playNum;

    private Short isPass;

    private String exContent;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String nikeName;

    private String headPortrait;

    private Integer likeNum;

    private Integer commentNum;

    private Short isLike;

    private String tagName;

}
