package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.About;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * 关于我们DTO
 *
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AboutDTO extends BaseDTO implements Serializable {

    private String phone;

    private String url;

    private String email;

    private String function;

    private String legalStatement;

    private String agreement;

    public About convertToAbout(){
        AboutConvertDto aboutConvertDto = new AboutConvertDto();
        return aboutConvertDto.doForward(this);
    }

    private static class AboutConvertDto extends BaseDtoConvert<AboutDTO, About>{
        @Override
        protected About doForward(AboutDTO aboutDTO) {
            About about = new About();
            BeanUtils.copyProperties(aboutDTO, about);
            return about;
        }

        @Override
        protected AboutDTO doBackward(About about) {
            AboutDTO aboutDTO = new AboutDTO();
            BeanUtils.copyProperties(about, aboutDTO);
            return aboutDTO;
        }
    }
}
