package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.Banner;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

/**
 * 广告管理相关DTO
 *
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BannerDTO extends BaseDTO {

    private Integer id;

    @NotNull
    private String imgName;

    @NotNull
    private String imgTitle;

    @NotNull
    private String imgUrl;

    @NotNull
    private String imgAddress;

    @NotNull
    private Integer imgSort;

    public Banner convertToBanner(){
        BannerDtoConvert bannerDtoConvert = new BannerDtoConvert();
        return bannerDtoConvert.doForward(this);
    }

    public BannerDTO covertFor(Banner banner){
        BannerDtoConvert bannerDtoConvert = new BannerDtoConvert();
        return bannerDtoConvert.doBackward(banner);
    }

    private static class BannerDtoConvert extends BaseDtoConvert<BannerDTO, Banner> {
        @Override
        public Banner doForward(BannerDTO bannerDTO) {
            Banner banner = new Banner();
            BeanUtils.copyProperties(bannerDTO, banner);
            return banner;
        }

        @Override
        public BannerDTO doBackward(Banner banner) {
            BannerDTO bannerDTO = new BannerDTO();
            BeanUtils.copyProperties(banner, bannerDTO);
            return bannerDTO;
        }
    }

}
