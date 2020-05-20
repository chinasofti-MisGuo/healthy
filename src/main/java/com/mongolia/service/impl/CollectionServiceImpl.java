package com.mongolia.service.impl;

import com.mongolia.dao.CollectionMapper;
import com.mongolia.model.entity.Collect;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.CollectionExample;
import com.mongolia.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 收藏相关Service实现
 *
 * @author Dong.w
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public Boolean isCollection(Collect collection) {
        CollectionExample collectionExample = productionExample(collection);
        int result = collectionMapper.countByExample(collectionExample);
        return (result != 0);
    }

    @Override
    public Boolean collect(Collect collection) {
        CollectionExample collectionExample = productionExample(collection);
        List<Collect> collections = collectionMapper.selectByExample(collectionExample);
        int result = 0;
        if (Objects.nonNull(collections)) {
            for (Collect col : collections) {
                if (Objects.equals(StateType.NO.getValue(), col.getIsDel())) {
                    col.setIsDel(StateType.YES.getValue());
                } else if (Objects.equals(StateType.YES.getValue(), col.getIsDel())) {
                    col.setIsDel(StateType.NO.getValue());
                }
                result = collectionMapper.updateByPrimaryKeySelective(col);
            }
        }
        if (Objects.isNull(collections) || collections.isEmpty()) {
            result = collectionMapper.insertSelective(collection);
        }
        return (result != 0);
    }

    @Override
    public boolean deleteCollect(Long uid) {
        CollectionExample collectionExample = new CollectionExample();
        collectionExample.createCriteria().andUidEqualTo(uid);
        Collect collect = new Collect();
        collect.setIsDel(StateType.YES.getValue());
        int result = collectionMapper.updateByExampleSelective(collect, collectionExample);
        return (result != 0);
    }

    private CollectionExample productionExample(Collect collection) {
        CollectionExample collectionExample = new CollectionExample();
        CollectionExample.Criteria criteria = collectionExample.createCriteria();
        criteria.andUidEqualTo(collection.getUid());
        criteria.andCollIdEqualTo(collection.getCollId());
        criteria.andIsDelEqualTo(collection.getIsDel());
        return collectionExample;
    }

}
