package com.mongolia.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mongolia.dao.FeedbackMapper;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Feedback;
import com.mongolia.model.enums.StateType;
import com.mongolia.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 意见相关Service实现
 * @author Dong.w
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public int addFeedBack(Feedback feedback) {
        feedback.setCreateTime(new Date());
        return feedbackMapper.insertSelective(feedback);
    }

    @Override
    public PageInfo<Feedback> getList(PageDTO pageDTO) {
        List<Feedback> resultList = feedbackMapper.selectAll();
        if(Objects.isNull(resultList) || resultList.isEmpty()){
            resultList = Lists.newArrayList();
        }
        return new PageInfo<>(resultList);
    }

    @Override
    public int deleteFeedBack(Integer id) {
        Feedback feedback = new Feedback();
        feedback.setId(Long.parseLong(id.toString()));
        feedback.setIsDel(StateType.YES.getValue());
        return feedbackMapper.updateByPrimaryKeySelective(feedback);
    }

    @Override
    public int replyFeedBack(Feedback feedback) {
        feedback.setReplyTime(new Date());
        feedback.setState(StateType.YES.getValue());
        return feedbackMapper.updateByPrimaryKeySelective(feedback);
    }

    @Override
    public PageInfo<Feedback> searchList(SearchDTO searchDTO) {
        List<Feedback> resultList = feedbackMapper.selectByExample(searchDTO);
        if(Objects.isNull(resultList) || resultList.isEmpty()){
            resultList = Lists.newArrayList();
        }
        return new PageInfo<>(resultList);
    }
}
