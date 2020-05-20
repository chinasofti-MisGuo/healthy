package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.Dynamic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 动态请求数据
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DynamicDTO extends BaseDTO implements Serializable {

    private Long id;

    @NotNull
    @Min(1)
    private Long tagId;

    @NotNull
    private String image;

    @NotNull
    private String title;

    @NotNull
    @NotBlank
    private String audioTime;

    @NotNull
    private String content;

    @NotNull
    private String author;

    @NotNull
    private String artist;

    @Max(2)
    @Min(0)
    private Short isHeat;

    @Max(2)
    @Min(0)
    private Short isRec;

    @Max(2)
    @Min(1)
    private Short isRel;

    public Dynamic convertTo(){
        DynamicDtoConvert dynamicDtoConvert = new DynamicDtoConvert();
        return dynamicDtoConvert.doForward(this);
    }

    private static class DynamicDtoConvert extends BaseDtoConvert<DynamicDTO, Dynamic>{
        @Override
        protected Dynamic doForward(DynamicDTO dynamicDTO) {
            Dynamic dynamic = new Dynamic();
            BeanUtils.copyProperties(dynamicDTO, dynamic);
            return dynamic;
        }

        @Override
        protected DynamicDTO doBackward(Dynamic dynamic) {
            return null;
        }
    }

}
