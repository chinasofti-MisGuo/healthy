package com.mongolia.controller.app;

import com.mongolia.model.dto.FeedbackDTO;
import com.mongolia.model.entity.Feedback;
import com.mongolia.model.vo.result.FailedResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.service.FeedBackService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 意见反馈相关
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/app/feedback")
public class FeedbackController {

    @Resource
    private FeedBackService feedBackService;

    @PostMapping("/add")
    public BaseResultVO addFeedBack(@RequestBody @Valid FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackDTO.convertTo();
        int result = feedBackService.addFeedBack(feedback);
        return new SuccessResultVO(result);
    }

}
