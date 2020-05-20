package com.mongolia.model.vo;

import com.mongolia.model.entity.About;
import com.mongolia.model.vo.base.BaseVoConvert;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * 关于我们回传数据
 *
 * @author Dong.w
 */
@Data
public class AboutUsVO implements Serializable {

    private String function;

    private String legalStatement;

    private String agreement;

    private String url;

    public AboutUsVO convertTo(About about) {
        AboutUsConvert aboutUsConvert = new AboutUsConvert();
        return aboutUsConvert.doBackward(about);
    }

    private static class AboutUsConvert extends BaseVoConvert<About, AboutUsVO> {

        @Override
        protected About doForward(AboutUsVO vo) {
            About about = new About();
            if(Objects.nonNull(vo)) {
                BeanUtils.copyProperties(vo, about);
            }
            return about;
        }

        @Override
        protected AboutUsVO doBackward(About about) {
            AboutUsVO aboutUsVO = new AboutUsVO();
            if (Objects.nonNull(about)) {
                BeanUtils.copyProperties(about, aboutUsVO);
            }
            return aboutUsVO;
        }
    }

}
