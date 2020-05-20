package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * 个人资料
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DatumDTO extends BaseDTO implements Serializable {

    private String nickname;

    private Short sex;

    private String city;

    private String birthday;

    private String profile;

    public User convertToUser(){
        DatumDtoConvert datumDtoConvert = new DatumDtoConvert();
        return datumDtoConvert.doForward(this);
    }

    private static class DatumDtoConvert extends BaseDtoConvert<DatumDTO, User>{
        @Override
        protected User doForward(DatumDTO datumDTO) {
            User user = new User();
            BeanUtils.copyProperties(datumDTO, user);
            return user;
        }

        @Override
        protected DatumDTO doBackward(User user) {
            return null;
        }
    }
}
