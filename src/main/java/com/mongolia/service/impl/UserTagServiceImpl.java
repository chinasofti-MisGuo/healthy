package com.mongolia.service.impl;

import com.google.common.collect.Lists;
import com.mongolia.dao.UserTagMapper;
import com.mongolia.model.entity.UserTag;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.UserTagExample;
import com.mongolia.service.UserTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户兴趣标签Service实现
 * @author Dong.w
 */
@Service
public class UserTagServiceImpl implements UserTagService {

    @Autowired
    private UserTagMapper userTagMapper;

    @Override
    public boolean addHobbyTag(UserTag userTag) {
        userTag.setCreateTime(new Date());
        int result = userTagMapper.insertSelective(userTag);
        return (result == 1);
    }

    @Override
    public List<Long> TagListByUid(Long uid) {
        UserTagExample userTagExample = new UserTagExample();
        UserTagExample.Criteria criteria = userTagExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andUidEqualTo(uid);
        List<UserTag> userTags = userTagMapper.selectByExample(userTagExample);
        List<Long> list = Lists.newArrayList();
        for(UserTag tag : userTags){
            list.add(tag.getTagId().longValue());
        }
        return list;
    }
}
