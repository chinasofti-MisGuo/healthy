package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户相关请求数据
 * @author Dong.w
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserDTO extends BaseDTO implements Serializable {

    @NotNull
    @Length(max = 11, min = 11)
    private String phone;

    private Integer code;

    private String password;

    private String fullname;

    private String idNumber;

    private String idCardImg;

    public User convertToUser(){
        UserConvertDto userConvertDto = new UserConvertDto();
        return userConvertDto.doForward(this);
    }

    private static class UserConvertDto extends BaseDtoConvert<UserDTO, User>{
        @Override
        protected User doForward(UserDTO userDTO) {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            return user;
        }

        @Override
        protected UserDTO doBackward(User user) {
            return null;
        }
    }

}
