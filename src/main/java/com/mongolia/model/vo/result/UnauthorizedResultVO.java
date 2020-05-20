package com.mongolia.model.vo.result;

import com.mongolia.model.enums.ResultCodeType;
import com.mongolia.model.vo.base.BaseResultVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 没有权限返回信息
 *
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UnauthorizedResultVO extends BaseResultVO {

    public UnauthorizedResultVO(){
        super(ResultCodeType.UNAUTHORIZED.value(), ResultCodeType.UNAUTHORIZED.getMessage(), new Object());
    }

}
