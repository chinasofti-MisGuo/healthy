package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 获取分页数据DTO
 *
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PageDTO extends BaseDTO {

    @Max(Long.MAX_VALUE)
    @Min(1)
    private Long id;

    @Max(Integer.MAX_VALUE)
    @Min(1)
    @NotNull
    private Integer page;

    @Max(Integer.MAX_VALUE)
    @Min(1)
    @NotNull
    private Integer limit;

}
