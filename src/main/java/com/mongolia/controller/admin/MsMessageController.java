package com.mongolia.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.MessageDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Message;
import com.mongolia.model.vo.result.BackPageResultVO;
import com.mongolia.model.vo.result.FailedResultVO;
import com.mongolia.model.vo.MessageVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.service.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 消息管理相关
 *
 * @author Dong.w
 */
@RestController
@RequestMapping("/api/admin/message")
public class MsMessageController {

    @Resource
    private MessageService messageService;

    @GetMapping("/list")
    public BaseResultVO getList(@Valid PageDTO pageDTO) {
        PageInfo<Message> messageList = messageService.getList(pageDTO);
        List list = VoFactory.doBackwardList(messageList.getList(), MessageVO.class);
        return new BackPageResultVO(messageList.getTotal(), list);
    }

    @PostMapping("/add")
    public BaseResultVO addMessage(@Valid MessageDTO messageDTO) {
        Message message = messageDTO.convertToMessage();
        int result = messageService.addMessage(message);
        return new SuccessResultVO(result);
    }

    @GetMapping("/search")
    public BaseResultVO searchMessage(@Valid SearchDTO searchDTO) {
        PageInfo<Message> messageList = messageService.getSearchList(searchDTO);
        List list = VoFactory.doBackwardList(messageList.getList(), MessageVO.class);
        return new BackPageResultVO(messageList.getTotal(), list);
    }

}
