package com.mongolia.model.vo.result;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 后台管理分页结果
 *
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BackPageResultVO extends SuccessResultVO {
    private Long count;

    public BackPageResultVO(Long count ,Object data){
        super(data);
        this.count = count;
    }
}
