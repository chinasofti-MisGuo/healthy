package com.mongolia.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 评论数据VO
 * @author Dong.w
 */
@Data
public class CommentVO implements Serializable {

    private Long id;

    private Long uid;

    private Long comId;

    private String content;

    private Long baseId;

    private Short isDel;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String nickName;

    private String headPortrait;

    private Integer commentNum;

    private Integer likeNum;

    private Short isLike;

    private List<CommentVO> commentList = Lists.newArrayList();

}
