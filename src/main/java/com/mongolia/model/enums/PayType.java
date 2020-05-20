package com.mongolia.model.enums;

/**
 * 支付方式
 * @author Dong.w
 */
public enum PayType {

    /**
     *  未支付
     */
    NOT(0),

    /**
     * 支付宝支付
     */
    ALIPAY(1),

    /**
     * 微信支付
     */
    WECHAT(2),

    /**
     * 积分支付
     */
    INTEGRAL(3),

    /**
     * 支付失败
     */
    FAIL(1),

    /**
     * 处理中
     */
    HANDLE(2),

    /**
     * 支付成功
     */
    SUCCESS(3);

    private final short value;

    PayType(int value){
        if(value > Short.MAX_VALUE){
            throw new IllegalArgumentException("Parameter is greater than Short.MAX_VALUE");
        }
        this.value = (short) value;
    }

    public short getValue(){
        return value;
    }

}
