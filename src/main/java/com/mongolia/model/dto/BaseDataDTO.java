package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 删除信息接收数据
 *
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BaseDataDTO extends BaseDTO {

    @Max(Long.MAX_VALUE)
    @Min(1)
    private Integer id;

    private Long oUid;

    private Short flag;

    private String tmp;

}
