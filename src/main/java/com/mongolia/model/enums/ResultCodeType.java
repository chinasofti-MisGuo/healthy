package com.mongolia.model.enums;

/**
 * 状态码
 *
 * @author Dong.w
 */
public enum ResultCodeType {

    /**
     * 请求成功
     */
    SUCCESS(200, "success"),

    /**
     * 无内容
     */
    NO_CONTENT(204, "No Content"),

    /**
     * 请求参数有误
     */
    BAD_REQUEST(400, "Bad Request"),

    /**
     * 没有权限
     */
    UNAUTHORIZED(401, "Unauthorized"),

    /**
     * 不存在
     */
    NOT_FOUND(404, "Not Found"),

    /**
     * 服务器错误
     */
    FAILED(500,"Failed"),

    /**
     * 信息有误
     */
    INCORRECT_INFORMATION(402, "Incorrect Information"),

    /**
     * 资源已存在
     */
    EXISTED(201,"existed"),

    /**
     * 请求方式有误
     */
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),

    /**
     * 请求数据类型错误
     */
    UNSUPPORTED_MEDIA_TYPE(415,"Unsupported Media Type");

    private final int code;

    private final String message;

    ResultCodeType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int value() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
