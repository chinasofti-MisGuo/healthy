package com.mongolia.model.vo;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.mongolia.model.entity.About;
import com.mongolia.model.vo.base.BaseVoConvert;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * 联系我们回传数据
 *
 * @author Dong.w
 */
@Data
public class ContactUsVO implements Serializable {

    private String phone;

    private String url;

    private String email;

    public ContactUsVO convertTo(About about){
        ContactUsConvert contactUsConvert = new ContactUsConvert();
        return contactUsConvert.doBackward(about);
    }

    private static class ContactUsConvert extends BaseVoConvert<About, ContactUsVO>{

        @Override
        protected About doForward(ContactUsVO contactUsVO) {
            About about = new About();
            if (Objects.nonNull(contactUsVO)) {
                BeanUtils.copyProperties(contactUsVO, about);
            }
            return about;
        }

        @Override
        protected ContactUsVO doBackward(About about) {
            ContactUsVO contactUsVO = new ContactUsVO();
            if (Objects.nonNull(about)) {
                BeanUtils.copyProperties(about, contactUsVO);
            }
            return contactUsVO;
        }
    }
}
