package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.AudioClass;
import com.mongolia.model.entity.RadioClass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ClassDTO extends BaseDTO implements Serializable {

    @Min(1)
    private Integer id;

    private String className;

    private String title;

    @Min(1)
    @Max(4)
    private Short level;

    @Min(1)
    private Integer sort;

    private Integer baseId;

    public AudioClass convertToAudioClass(){
        AudioClass audioClass = new AudioClass();
        BeanUtils.copyProperties(this, audioClass);
        return audioClass;
    }

    public RadioClass convertToRadioClass(){
        RadioClass radioClass = new RadioClass();
        BeanUtils.copyProperties(this, radioClass);
        return radioClass;
    }
}
