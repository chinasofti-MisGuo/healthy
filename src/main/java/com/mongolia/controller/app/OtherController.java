package com.mongolia.controller.app;

import com.google.common.collect.Lists;
import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.entity.About;
import com.mongolia.model.entity.Problem;
import com.mongolia.model.entity.Task;
import com.mongolia.model.vo.AboutUsVO;
import com.mongolia.model.vo.ContactUsVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.service.AboutService;
import com.mongolia.service.ProblemService;
import com.mongolia.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * API接口
 * 接收app端获取数据
 * 其中包括 常见问题、功能介绍、法律声明、各种协议、联系我们等相关数据
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/app")
public class OtherController {

    @Autowired
    private ProblemService problemService;

    @Autowired
    private AboutService aboutService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/problem")
    public BaseResultVO getProblem(@Valid BaseDTO dto) {
        List<Problem> list = problemService.appGetProblem();
        if (Objects.isNull(list)) {
            list = Lists.newArrayList();
        }
        return new SuccessResultVO(list);
    }

    @GetMapping("/about")
    public BaseResultVO getAboutUs(@Valid BaseDTO baseDTO) {
        Optional<About> aboutUs = aboutService.getAboutUs();
        AboutUsVO aboutUsVO = new AboutUsVO().convertTo(aboutUs.orElse(new About()));
        return new SuccessResultVO(aboutUsVO);
    }

    @GetMapping("/contact")
    public BaseResultVO getContactUs(@Valid BaseDTO baseDTO) {
        Optional<About> contactUs = aboutService.getContactUs();
        ContactUsVO contactUsVO = new ContactUsVO().convertTo(contactUs.orElse(new About()));
        return new SuccessResultVO(contactUsVO);
    }

    @GetMapping("/agreement")
    public BaseResultVO getUseAgreement(@Valid BaseDTO baseDTO) {
        String agreement = aboutService.getUseAgreement();
        return new SuccessResultVO(agreement);
    }

    @GetMapping("/task")
    public BaseResultVO taskList(@Valid BaseDTO baseDTO){
        List<Task> list = taskService.taskAll();
        return new SuccessResultVO(list);
    }

}
