package com.mongolia.model.vo.result;

import com.mongolia.model.enums.ResultCodeType;
import com.mongolia.model.vo.base.BaseResultVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 请求资源不存在
 * @author Dong.w
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NotFoundResultVO extends BaseResultVO {

    public NotFoundResultVO(Object data){
        super(ResultCodeType.NOT_FOUND.value(),ResultCodeType.NOT_FOUND.getMessage(),data);
    }

    public NotFoundResultVO(){
        super(ResultCodeType.NOT_FOUND.value(), ResultCodeType.NOT_FOUND.getMessage(),"不存在");
    }

}
