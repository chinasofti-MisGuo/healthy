package com.mongolia.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 音频目录VO
 * @author Dong.w
 */
@Data
public class AudioDirVO implements Serializable {

    private Long id;

    private String title;

    private Integer classId;

    private String introduce;

    private String imagePath;

    private String clazzName;

    private List<TagVO> tagList;

    private BigDecimal price;

    private Integer likeNum;

    private Integer commentNum;

    private Integer playNum;

    private Short flag;

    private Short ifRel;

    private Short ifRec;

    private Short isLike;

    private Short isColl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
