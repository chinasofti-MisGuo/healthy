package com.mongolia.controller.app;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.entity.Banner;
import com.mongolia.model.vo.BannerVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 首页相关接口
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/app/index")
public class HomeIndexController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/banner")
    public BaseResultVO getBanner(@Valid BaseDTO baseDTO){
        PageInfo<Banner> bannerPageInfo = bannerService.indexGetList();
        List list = VoFactory.doBackwardList(bannerPageInfo.getList(), BannerVO.class);
        return new SuccessResultVO(list);
    }
}
