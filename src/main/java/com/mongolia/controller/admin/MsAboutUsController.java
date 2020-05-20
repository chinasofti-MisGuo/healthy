package com.mongolia.controller.admin;



import com.mongolia.model.dto.AboutDTO;
import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.entity.About;
import com.mongolia.model.vo.AboutUsVO;
import com.mongolia.model.vo.ContactUsVO;
import com.mongolia.model.vo.result.FailedResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.service.AboutService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Optional;

/**
 * 关于我们相关后台管理接口
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/admin/about")
public class MsAboutUsController {

    @Resource
    private AboutService aboutService;

    @GetMapping("/us")
    public BaseResultVO getAboutUs(@Valid BaseDTO baseDTO){
        Optional<About> about = aboutService.getAboutUs();
        AboutUsVO aboutUsVO = new AboutUsVO().convertTo(about.orElse(new About()));
        return new SuccessResultVO(aboutUsVO);
    }

    @GetMapping("/contact")
    public BaseResultVO getContactUs(@Valid BaseDTO baseDTO){
        Optional<About> about = aboutService.getContactUs();
        ContactUsVO contactUsVO = new ContactUsVO().convertTo(about.orElse(new About()));
        return new SuccessResultVO(contactUsVO);
    }

    @PostMapping("/edit")
    public BaseResultVO editAboutUs(@RequestBody AboutDTO aboutDTO){
        About about = aboutDTO.convertToAbout();
        int result = aboutService.editAboutUs(about);
        if(result == 0){
            return new FailedResultVO();
        }else{
            return new SuccessResultVO(result);
        }
    }
}
