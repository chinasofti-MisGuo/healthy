package com.mongolia.model.entity;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 评论数据实体
 * @author Dong.w
 */
@Data
public class Comment implements Serializable {

    private Long id;

    private Long uid;

    private Long comId;

    private String content;

    private Long baseId;

    private Short flag;

    private Short isDel;

    private Short isLike;

    private Integer likeNum;

    private String nickName;

    private String phone;

    private String headPortrait;

    private Integer commentNum;

    private Date createTime;

    private Date updateTime;

    private List<Comment> commentList = Lists.newArrayList();

}