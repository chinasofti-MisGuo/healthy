package com.mongolia.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 反馈数据实体
 * @author Dong.w
 */
@Data
public class Feedback implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 反馈用户uid
     */
    private Long uid;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 反馈内容
     */
    private String content;

    /**
     * 回复内容
     */
    private String reply;

    /**
     * 回复反馈id
     */
    private Long replyId;

    /**
     * 回复状态  0：未回复  1：已回复
     */
    private Short state;

    /**
     * 反馈时间
     */
    private Date createTime;

    /**
     * 回复时间
     */
    private Date replyTime;

    /**
     * 是否删除  0：未删除  1：已删除
     */
    private Short isDel;

    private static final long serialVersionUID = 1L;

    /**
     * 用户昵称
     */
    private String username;

}
