package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.SetMeal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 套餐请求数据
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SetMealDTO extends BaseDTO implements Serializable {

    @Min(1)
    private Integer id;

    @NotNull
    private String logoPath;

    @NotNull
    private String name;

    @NotNull
    @Min(0)
    private BigDecimal price;

    @NotNull
    private String explain;

    @NotNull
    @Min(0)
    private BigDecimal quota;

    public SetMeal convertToSetMeal(){
        SetMealDtoConvert setMealDtoConvert = new SetMealDtoConvert();
        return setMealDtoConvert.doForward(this);
    }

    private static class SetMealDtoConvert extends BaseDtoConvert<SetMealDTO, SetMeal>{

        @Override
        protected SetMeal doForward(SetMealDTO setMealDTO) {
            SetMeal setMeal = new SetMeal();
            BeanUtils.copyProperties(setMealDTO, setMeal);
            return setMeal;
        }

        @Override
        protected SetMealDTO doBackward(SetMeal setMeal) {
            return null;
        }
    }

}
