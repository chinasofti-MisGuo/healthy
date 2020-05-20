package com.mongolia.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;
import com.mongolia.dao.FollowMapper;
import com.mongolia.model.entity.Follow;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.FollowExample;
import com.mongolia.service.FollowService;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 关注相关Service实现
 * @author Dong.w
 */
@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowMapper followMapper;

    @Override
    public boolean isFollow(Long uid, Long oUid) {
        FollowExample followExample = productionExample();
        FollowExample.Criteria criteria = followExample.createCriteria();
        criteria.andFolUidEqualTo(uid);
        criteria.andBeUidEqualTo(oUid);
        List<Follow> follows = followMapper.selectByExample(followExample);
        return !(Objects.isNull(follows) || follows.isEmpty());
    }

    @Override
    public Integer fansNumber(Long uid) {
        FollowExample followExample = productionExample();
        FollowExample.Criteria criteria = followExample.createCriteria();
        criteria.andBeUidEqualTo(uid);
        return followMapper.countByExample(followExample);
    }

    @Override
    public Integer attentionNumber(Long uid) {
        FollowExample followExample = new FollowExample();
        FollowExample.Criteria criteria = followExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andFolUidEqualTo(uid);
        return followMapper.countByExample(followExample);
    }

    @Override
    public List<Follow> getUserFans(Long uid) {
        List<Follow> follows = followMapper.selectFans(uid);
        if(Objects.isNull(follows)){
            follows = Lists.newArrayList();
        }
        return follows;
    }

    @Override
    public List<Follow> getCollect(Long uid) {
        List<Follow> follows = followMapper.selectCollect(uid);
        if(Objects.isNull(follows)){
            follows = Lists.newArrayList();
        }
        return follows;
    }

    @Override
    public boolean andFollow(Follow follow) {
        FollowExample followExample = new FollowExample();
        FollowExample.Criteria criteria = followExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        criteria.andFolUidEqualTo(follow.getFolUid());
        criteria.andBeUidEqualTo(follow.getBeUid());
        List<Follow> follows = followMapper.selectByExample(followExample);
        if (!CollectionUtil.isEmpty(follows)){
            Follow followBySel = follows.get(0);
            if (NumberUtils.compare(followBySel.getIsDel(), StateType.NO.getValue()) == 0){
                followBySel.setIsDel(StateType.YES.getValue());
            }else if(NumberUtils.compare(followBySel.getIsDel(), StateType.YES.getValue()) == 0){
                followBySel.setIsDel(StateType.NO.getValue());
            }
            int result = followMapper.updateByPrimaryKeySelective(followBySel);
            return (result != 0);
        }else {
            follow.setCreateTime(new Date());
            int result = followMapper.insertSelective(follow);
            return (result == 1);
        }
    }

    private FollowExample productionExample(){
        FollowExample followExample = new FollowExample();
        FollowExample.Criteria criteria = followExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        return followExample;
    }

}
