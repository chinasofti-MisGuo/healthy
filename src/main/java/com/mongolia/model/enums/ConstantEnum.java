package com.mongolia.model.enums;

/**
 * 常量枚举
 * @author Dong.w
 */
public enum  ConstantEnum {

    /**
     * 加密——盐值
     */
    ENCRYPTION_KEY("mongolia");

    private Object value;

    ConstantEnum(Object value){
        this.value = value;
    }

    public Object getValue(){
        return value;
    }
}
