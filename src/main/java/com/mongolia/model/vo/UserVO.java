package com.mongolia.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mongolia.model.entity.User;
import com.mongolia.model.vo.base.BaseVoConvert;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户数据VO
 * @author Dong.w
 */
@Data
public class UserVO implements Serializable {

    private Long id;

    private Long uid;

    private String phone;

    private String nickname;

    private String password;

    private String wechatId;

    private String qq;

    private String fullname;

    private String idNumber;

    private String idCardImg;

    private Short sex;

    private String city;

    private String birthday;

    private String profile;

    private String headPortrait;

    private Short age;

    private Short auditState;

    private Short state;

    private Short comState;

    private Short isVip;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date vipDueTime;

    private String token;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date loginTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public UserVO convertTo(User user){
        UserVoConvert userVoConvert = new UserVoConvert();
        return userVoConvert.doBackward(user);
    }

    private static class UserVoConvert extends BaseVoConvert<User, UserVO>{
        @Override
        protected User doForward(UserVO userVO) {
            return null;
        }

        @Override
        protected UserVO doBackward(User user) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            return userVO;
        }
    }

}
