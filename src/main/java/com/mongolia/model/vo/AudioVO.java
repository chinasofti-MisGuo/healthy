package com.mongolia.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 音频回传VO
 * @author Dong.w
 */
@Data
public class AudioVO implements Serializable {

    private Long id;

    private String title;

    private String introduce;

    private String image;

    private String audioPath;

    private String lrcPath;

    private String audioTime;

    private Short ifPay;

    private Short ifRel;

    private Short ifRec;

    private Date createTime;

}
