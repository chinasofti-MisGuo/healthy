package com.mongolia.model.enums;

/**
 * 状态类型
 * @author Dong.w
 */
public enum StateType {

    /**
     * 审核未通过
     */
    NOT_PASS(-1),

    /**
     * 未删除
     * 免费
     * 未上架
     * 未推荐
     * 非热门
     * 未审核
     * 未回复
     * 不是会员
     * 用户状态正常
     */
    NO(0),

    /**
     * 删除
     * 收费
     * 上架
     * 推荐
     * 热门
     * 审核通过
     * 回复
     * 会员
     * 用户状态冻结
     */
    YES(1),

    /**
     * 冻结用户评论
     */
    FROZEN_COM(2);

    private final short value;

    StateType(int value){
        if(value > Short.MAX_VALUE){
            throw new IllegalArgumentException("Parameter is greater than Short.MAX_VALUE");
        }
        this.value = (short) value;
    }

    public short getValue(){
        return value;
    }
}
