package com.mongolia.model.vo.result;

import com.mongolia.model.enums.ResultCodeType;
import com.mongolia.model.vo.base.BaseResultVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/**
 * 请求参数有误数据VO
 *
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BadRequestResultVO extends BaseResultVO {

    public BadRequestResultVO(){
        super(ResultCodeType.BAD_REQUEST.value(), ResultCodeType.BAD_REQUEST.getMessage(), new Object());
    }

    public BadRequestResultVO(Object data){
        super(ResultCodeType.BAD_REQUEST.value(), ResultCodeType.BAD_REQUEST.getMessage(), data);
    }

}
