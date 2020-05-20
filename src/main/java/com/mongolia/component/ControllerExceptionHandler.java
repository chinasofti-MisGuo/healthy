package com.mongolia.component;

import com.mongolia.exception.ExistedException;
import com.mongolia.exception.InformationErrorException;
import com.mongolia.exception.UserNotFoundException;
import com.mongolia.model.enums.ResultCodeType;
import com.mongolia.model.vo.result.*;
import com.mongolia.model.vo.base.BaseResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 全局异常处理
 *
 * @author Dong.w
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    /**
     * 资源已存在异常
     * @param e 异常信息
     * @return
     */
    @ExceptionHandler(ExistedException.class)
    public BaseResultVO existedExceptionHandler(ExistedException e){
        e.printStackTrace();
        log.error("existed error -> [{}]", e.getMessage());
        return new BaseResultVO(ResultCodeType.EXISTED, e.getMessage());
    }

    /**
     * 数据异常
     *
     * @param e 异常信息
     * @return 错误信息
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResultVO bindExceptionHandler(MethodArgumentNotValidException e) {
        String errorDetail = errorDetail(e.getBindingResult().getFieldErrors());
        e.printStackTrace();
        log.error("data exception error -> [{}]", e.getMessage());
        return new BadRequestResultVO(errorDetail);
    }

    /**
     * 信息有误异常处理
     * @param e 异常信息
     * @return  错误信息
     */
    @ExceptionHandler(InformationErrorException.class)
    public BaseResultVO informationErrorHandler(InformationErrorException e){
        e.printStackTrace();
        log.error("information error -> [{0}]", e);
        return new IncorrectResultVO(e.getMessage());
    }

    /**
     * 全局用户不存在异常
     * @param e 异常信息
     * @return  错误信息
     */
    @ExceptionHandler(UserNotFoundException.class)
    public BaseResultVO userNotFoundExceptionHandler(UserNotFoundException e){
        e.printStackTrace();
        log.error("user not found -> [{0}]", e);
        return new NotFoundResultVO("用户不存在");
    }

    /**
     * 全局数据绑定异常
     * @param e 异常信息
     * @return  错误信息
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public BaseResultVO bindExceptionHandler(BindException e){
        String errorDetail = errorDetail(e.getFieldErrors());
        e.printStackTrace();
        log.error("user not found -> [{}]", e.getMessage());
        return new BadRequestResultVO(errorDetail);
    }

    /**
     * 请求数据类型错误全局异常
     * @param e 异常信息
     * @return  错误信息
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResultVO httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e){
        log.error("json parse exception -> [{}]", e.getMessage());
        return new BaseResultVO(ResultCodeType.UNSUPPORTED_MEDIA_TYPE, "请求数据格式有误");
    }

    /**
     * 请求方式错误全局异常
     * @param e 异常信息
     * @return  错误信息
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public BaseResultVO httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e){
        log.error("HttpRequestMethodNotSupportedException -> [{}]", e.getMessage());
        return new BaseResultVO(ResultCodeType.METHOD_NOT_ALLOWED, "请求方式有误");
    }

    /**
     * 运行时异常全局处理
     * @param e 异常信息
     * @return  错误信息
     */
    @ExceptionHandler(RuntimeException.class)
    public BaseResultVO runtimeExceptionHandler(RuntimeException e){
        log.error("error -> [{}]", e.getMessage());
        log.error("error -> [{}]", e.getStackTrace());
        e.printStackTrace();
        return new BaseResultVO(ResultCodeType.FAILED, "error");
    }

    /**
     * 全局Exception异常处理
     *
     * @param e 异常信息
     * @return 错误信息
     */
    @ExceptionHandler(Exception.class)
    public BaseResultVO exceptionHandler(Exception e) {
        e.printStackTrace();
        log.error("exception error -> [{}]", e.getMessage());
        log.error("exception error -> [{}]", e.getStackTrace());
        return new FailedResultVO("error");
    }

    /**
     * 全局Throwable异常处理
     *
     * @param e 异常信息
     * @return 错误信息
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public BaseResultVO throwableHandler(Throwable e) {
        e.printStackTrace();
        log.error("throwable error -> [{}]", e.getMessage());
        log.error("throwable error -> [{}]", e.getStackTrace());
        return new FailedResultVO();
    }

    private String errorDetail(List<FieldError> errors){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, length = errors.size(); i < length; i++) {
            FieldError error = errors.get(i);
            stringBuilder.append(error.getField());
            stringBuilder.append(":");
            stringBuilder.append(error.getDefaultMessage());
            if(i != length - 1) {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }
}
