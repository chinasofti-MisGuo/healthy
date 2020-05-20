package com.mongolia.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.BannerDTO;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.entity.Banner;
import com.mongolia.model.vo.result.BackPageResultVO;
import com.mongolia.model.vo.BannerVO;
import com.mongolia.model.vo.result.FailedResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.service.BannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 后台管理广告管理
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/admin/banner")
public class MsBannerController {

    @Autowired
    private BannerService bannerService;

    /**
     * 获取分页列表
     *
     * @param pageDTO 分页信息
     * @return result
     */
    @GetMapping("/list")
    public BaseResultVO getList(@Valid PageDTO pageDTO) {
        PageInfo<Banner> bannerList = bannerService.getList(pageDTO);
        List result = VoFactory.doBackwardList(bannerList.getList(), BannerVO.class);
        return new BackPageResultVO(bannerList.getTotal(), result);
    }

    @GetMapping("/sort/{id}")
    public BaseResultVO sortList(@Valid BaseDTO baseDTO, @PathVariable("id") Integer id) {
        List list = bannerService.allSort(id);
        return new SuccessResultVO(list);
    }

    @PostMapping("/add")
    public BaseResultVO addBanner(@RequestBody @Valid BannerDTO bannerDTO) {
        Banner banner = bannerDTO.convertToBanner();
        int result = bannerService.saveBanner(banner);
        return new SuccessResultVO(result);
    }

    @PostMapping("/edit")
    public BaseResultVO editBanner(@RequestBody @Valid BannerDTO bannerDTO) {
        Banner banner = bannerDTO.convertToBanner();
        int result = bannerService.editBanner(banner);
        return new SuccessResultVO(result);
    }

    @PostMapping("/del")
    public BaseResultVO deleteBanner(@RequestBody @Valid BaseDataDTO baseDataDTO) {
        int result = bannerService.deleteBanner(baseDataDTO);
        return new SuccessResultVO(result);
    }

    @GetMapping("/search")
    public BaseResultVO searchBanner(@Valid SearchDTO searchDTO) {
        PageInfo<Banner> bannerList = bannerService.getSearchList(searchDTO);
        List list = VoFactory.doBackwardList(bannerList.getList(), BannerVO.class);
        return new BackPageResultVO(bannerList.getTotal(), list);
    }

    @PostMapping("/upper")
    public BaseResultVO upperShelf(@RequestBody @Valid BaseDataDTO baseDataDTO) {
        int result = bannerService.upperShelf(baseDataDTO);
        return new SuccessResultVO(result);
    }
}
