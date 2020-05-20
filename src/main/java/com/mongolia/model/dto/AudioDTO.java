package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.Audio;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 音频数据
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AudioDTO extends BaseDTO implements Serializable {

    @Min(1)
    private Long id;

    @NotNull
    @Min(1)
    private Long dirId;

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String introduce;

    @NotNull
    @NotBlank
    private String image;

    @NotNull
    @NotBlank
    private String audioPath;

    @NotNull
    @NotBlank
    private String audioTime;

    @NotNull
    @NotBlank
    private String lrcPath;

    @Min(0)
    private Short ifPay;

    public Audio convertToAudio(){
        AudioDtoConvert audioDtoConvert = new AudioDtoConvert();
        return audioDtoConvert.doForward(this);
    }

    private static class AudioDtoConvert extends BaseDtoConvert<AudioDTO, Audio>{
        @Override
        protected Audio doForward(AudioDTO audioDTO) {
            Audio audio = new Audio();
            BeanUtils.copyProperties(audioDTO, audio);
            return audio;
        }

        @Override
        protected AudioDTO doBackward(Audio audio) {
            return null;
        }
    }

}
