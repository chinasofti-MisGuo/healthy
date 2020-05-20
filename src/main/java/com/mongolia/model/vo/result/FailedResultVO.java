package com.mongolia.model.vo.result;

import com.mongolia.model.enums.ResultCodeType;
import com.mongolia.model.vo.base.BaseResultVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 请求失败返回数据
 *
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FailedResultVO extends BaseResultVO {

    public FailedResultVO(){
        super(ResultCodeType.FAILED.value(), ResultCodeType.FAILED.getMessage(), "error");
    }

    public FailedResultVO(Object data){
        super(ResultCodeType.FAILED.value(), ResultCodeType.FAILED.getMessage(), data);
    }
}
