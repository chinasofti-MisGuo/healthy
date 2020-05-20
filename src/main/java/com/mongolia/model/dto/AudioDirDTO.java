package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.AudioDir;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 音频目录
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AudioDirDTO extends BaseDTO implements Serializable {

    private Long id;

    @NotNull
    @Min(1)
    private Integer classId;

    @NotNull
    private String title;

    @NotNull
    private String introduce;

    @NotNull
    private String imagePath;

    private BigDecimal price;

    @NotNull
    private Short flag;

    private Short ifRel;

    private Short ifRec;

    private String tag;

    public AudioDir convertToAudioDir(){
        AudioDirDtoConvert audioDirDtoConvert = new AudioDirDtoConvert();
        return audioDirDtoConvert.doForward(this);
    }

    private static class AudioDirDtoConvert extends BaseDtoConvert<AudioDirDTO, AudioDir>{
        @Override
        protected AudioDir doForward(AudioDirDTO audioDirDTO) {
            AudioDir audioDir = new AudioDir();
            BeanUtils.copyProperties(audioDirDTO, audioDir);
            return audioDir;
        }

        @Override
        protected AudioDirDTO doBackward(AudioDir audioDir) {
            return null;
        }
    }

}
