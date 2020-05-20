package com.mongolia.model.enums;

/**
 * 类型标识枚举
 * @author Dong.w
 */
public enum FlagType {
    /**
     * 音频类型/音频目录点赞
     */
    AUDIO(1),

    /**
     * 音频点赞
     */
    AUDIO_LIKE(2),

    /**
     * 动态类型/动态点赞
     */
    DYNAMIC(3),

    /**
     * 电台类型
     */
    RADIO(4),

    /**
     * 评论类型
     */
    COMMENT(5);

    private final short value;

    FlagType(int value){
        if(value > Short.MAX_VALUE){
            throw new IllegalArgumentException("Parameter is greater than Short.MAX_VALUE");
        }
        this.value = (short) value;
    }

    public short getValue() {
        return value;
    }

}
