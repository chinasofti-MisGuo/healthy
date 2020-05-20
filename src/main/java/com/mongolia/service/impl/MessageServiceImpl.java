package com.mongolia.service.impl;

import com.github.pagehelper.PageInfo;
import com.mongolia.dao.MessageMapper;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Message;
import com.mongolia.model.example.MessageExample;
import com.mongolia.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 消息相关实现
 *
 * @author Dong.w
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Override
    public PageInfo<Message> getList(PageDTO pageDTO) {
        MessageExample messageExample = new MessageExample();
        messageExample.setOrderByClause("id DESC");
        MessageExample.Criteria criteria = messageExample.createCriteria();
        criteria.andIsDelEqualTo(Short.valueOf("0"));
        List<Message> messages = messageMapper.selectByExample(messageExample);
        return new PageInfo<>(messages);
    }

    @Override
    public int addMessage(Message message) {
        message.setCreateTime(new Date());
        return messageMapper.insertSelective(message);
    }

    @Override
    public PageInfo<Message> getSearchList(SearchDTO searchDTO) {
        MessageExample messageExample = new MessageExample();
        messageExample.setOrderByClause("id DESC");
        MessageExample.Criteria criteria = messageExample.createCriteria();
        criteria.andIsDelEqualTo(Short.valueOf("0"));
        if(!StringUtils.isEmpty(searchDTO.getTitle())){
            criteria.andMsgTitleLike(String.format("%%%s%%", searchDTO.getTitle()));
        }
        if(Objects.nonNull(searchDTO.getStart()) && Objects.nonNull(searchDTO.getEnd())){
            criteria.andCreateTimeBetween(searchDTO.getStart(), searchDTO.getEnd());
        }
        List<Message> messages = messageMapper.selectByExample(messageExample);
        return new PageInfo<>(messages);
    }
}
