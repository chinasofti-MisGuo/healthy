package com.mongolia.model.vo.result;

import com.mongolia.model.enums.ResultCodeType;
import com.mongolia.model.vo.base.BaseResultVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 信息有误
 *
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class IncorrectResultVO extends BaseResultVO {

    public IncorrectResultVO(){
        super(ResultCodeType.INCORRECT_INFORMATION.value(), ResultCodeType.INCORRECT_INFORMATION.getMessage(),new Object());
    }

    public IncorrectResultVO(Object data){
        super(ResultCodeType.INCORRECT_INFORMATION.value(), ResultCodeType.INCORRECT_INFORMATION.getMessage(),data);
    }

}
