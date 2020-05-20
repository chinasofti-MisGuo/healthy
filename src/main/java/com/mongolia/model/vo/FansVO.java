package com.mongolia.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 粉丝数据VO
 * @author Dong.w
 */
@Data
public class FansVO implements Serializable {

    private Long folUid;

    private Long beUid;

    private String nikeName;

    private String headPortrait;

    private Short state;

}
