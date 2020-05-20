package com.mongolia.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mongolia.exception.InformationErrorException;
import com.mongolia.model.dto.*;
import com.mongolia.model.entity.Feedback;
import com.mongolia.model.entity.IntegralRule;
import com.mongolia.model.entity.Order;
import com.mongolia.model.entity.Task;
import com.mongolia.model.vo.OrderVO;
import com.mongolia.model.vo.result.BackPageResultVO;
import com.mongolia.model.vo.result.FailedResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.service.FeedBackService;
import com.mongolia.service.IntegralRuleService;
import com.mongolia.service.OrderService;
import com.mongolia.service.TaskService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 后台管理意见反馈、财务管理相关
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/admin")
public class MsManagerController {

    @Autowired
    private FeedBackService feedBackService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private IntegralRuleService integralRuleService;

    @GetMapping("/feedback/list")
    public BaseResultVO getList(@Valid PageDTO pageDTO) {
        PageInfo<Feedback> resultList = feedBackService.getList(pageDTO);
        List list = VoFactory.doBackwardList(resultList.getList(), FeedbackDTO.class);
        return new BackPageResultVO(resultList.getTotal(), list);
    }

    @PostMapping("/feedback/del")
    public BaseResultVO delFeedback(@RequestBody @Valid BaseDataDTO dataDTO) {
        int result = feedBackService.deleteFeedBack(dataDTO.getId());
        if (result == 0) {
            return new FailedResultVO();
        } else {
            return new SuccessResultVO(result);
        }
    }

    @PostMapping("/feedback/reply")
    public BaseResultVO replyFeedBack(@RequestBody FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackDTO.convertTo();
        int result = feedBackService.replyFeedBack(feedback);
        if (result == 0) {
            return new FailedResultVO();
        } else {
            return new SuccessResultVO(result);
        }
    }

    @GetMapping("/feedback/search")
    public BaseResultVO searchFeedBack(@Valid SearchDTO searchDTO) {
        PageInfo<Feedback> feedbackPageInfo = feedBackService.searchList(searchDTO);
        List list = VoFactory.doBackwardList(feedbackPageInfo.getList(), FeedbackDTO.class);
        return new BackPageResultVO(feedbackPageInfo.getTotal(), list);
    }

    @GetMapping("/order/list")
    public BaseResultVO orderList(@Valid PageDTO pageDTO){
        PageInfo<Order> pageInfo = orderService.orderList(pageDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), OrderVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @GetMapping("/order/search")
    public BaseResultVO searchOrder(@Valid SearchDTO searchDTO){
        PageInfo<Order> pageInfo = orderService.searchOrderList(searchDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), OrderVO.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @GetMapping("/task/list")
    public BaseResultVO taskList(@Valid PageDTO pageDTO){
        PageInfo<Task> taskPageInfo = taskService.taskList(pageDTO);
        return new BackPageResultVO(taskPageInfo.getTotal(), taskPageInfo.getList());
    }

    @GetMapping("/task/search")
    public BaseResultVO searchTask(@Valid SearchDTO searchDTO){
        PageInfo<Task> taskPageInfo = taskService.searchTaskList(searchDTO);
        return new BackPageResultVO(taskPageInfo.getTotal(), taskPageInfo.getList());
    }

    @PostMapping("/task/edit")
    public BaseResultVO editTask(@RequestBody @Valid TaskDTO taskDTO){
        Task task = taskDTO.convertToTask();
        boolean result = taskService.editTask(task);
        return new SuccessResultVO(result ? 1 : 0);
    }

    @GetMapping("/integral/rule/list")
    public BaseResultVO integralRuleList(){
        List<IntegralRule> integralRules = integralRuleService.allRule();
        return new SuccessResultVO(integralRules);
    }

    @PostMapping("/integral/rule/add")
    public BaseResultVO addIntegralRule(@RequestBody IntegralRule integralRule){
        if(StringUtils.isEmpty(integralRule.getProportion())
                && StringUtils.isEmpty(integralRule.getDescription())){
            throw new InformationErrorException("请求参数有误");
        }
        int result = integralRuleService.addIntegralRule(integralRule);
        return new SuccessResultVO(result);
    }

    @PostMapping("/integral/rule/edit")
    public BaseResultVO editIntegralRule(@RequestBody IntegralRule integralRule){
        if(StringUtils.isEmpty(integralRule.getProportion())
                && StringUtils.isEmpty(integralRule.getDescription())){
            throw new InformationErrorException("请求参数有误");
        }
        int result = integralRuleService.editIntegralRule(integralRule);
        return new SuccessResultVO(result);
    }

}
