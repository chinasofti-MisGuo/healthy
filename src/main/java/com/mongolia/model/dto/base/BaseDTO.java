package com.mongolia.model.dto.base;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * DTO基类
 *
 * @author Dong.w
 */
@Data
public class BaseDTO implements Serializable {

    @NotNull
    @Length(min = 32)
    private String token;

    private Long uid;

}
