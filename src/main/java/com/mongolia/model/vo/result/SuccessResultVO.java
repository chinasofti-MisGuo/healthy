package com.mongolia.model.vo.result;

import com.mongolia.model.enums.ResultCodeType;
import com.mongolia.model.vo.base.BaseResultVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 请求成功返回结果
 *
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SuccessResultVO extends BaseResultVO {

    public SuccessResultVO(Object data){
        super(ResultCodeType.SUCCESS, data);
    }

}
