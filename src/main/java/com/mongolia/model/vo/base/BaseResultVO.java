package com.mongolia.model.vo.base;

import com.mongolia.model.enums.ResultCodeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回数据基类
 *
 * @author Dong.w
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResultVO implements Serializable {

    private Integer code;

    private String message;

    private Object data;

    public BaseResultVO(ResultCodeType result, Object data){
        this.code = result.value();
        this.message = result.getMessage();
        this.data = data;
    }

}
