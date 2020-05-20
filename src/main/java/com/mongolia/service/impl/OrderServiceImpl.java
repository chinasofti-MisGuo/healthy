package com.mongolia.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mongolia.dao.OrderMapper;
import com.mongolia.dao.UserMapper;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Order;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.OrderExample;
import com.mongolia.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * 订单相关service实现
 *
 * @author Dong.w
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<Order> orderList(PageDTO pageDTO) {
        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause("id DESC");
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<Order> orders = orderMapper.selectByExample(orderExample);
        if (Objects.isNull(orders)) {
            orders = Lists.newArrayList();
        }
        return new PageInfo<>(orders);
    }

    @Override
    public PageInfo<Order> searchOrderList(SearchDTO searchDTO) {
        OrderExample orderExample = new OrderExample();
        orderExample.setOrderByClause("id DESC");
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        if (StringUtils.isNotEmpty(searchDTO.getTitle())) {
            criteria.andOrderIdEqualTo(searchDTO.getTitle());
        }
        if (StringUtils.isNotEmpty(searchDTO.getName())) {
            List<Long> res = userMapper.selectUidLikeNikeName(searchDTO.getName());
            if(Objects.nonNull(res) && res.isEmpty()){
                return new PageInfo<>();
            }
            criteria.andUidIn(res);
        }
        if (Objects.nonNull(searchDTO.getState())) {
            criteria.andStateEqualTo(searchDTO.getState());
        }
        if (Objects.nonNull(searchDTO.getStart()) && Objects.nonNull(searchDTO.getEnd())) {
            criteria.andCreateTimeBetween(searchDTO.getStart(), searchDTO.getEnd());
        }
        if (Objects.nonNull(searchDTO.getFlag())) {
            criteria.andPayTypeEqualTo(searchDTO.getFlag());
        }
        if (StringUtils.isNotEmpty(searchDTO.getRange())) {
            String[] split = searchDTO.getRange().split(",");
            if (split.length >= 2) {
                criteria.andPriceBetween(new BigDecimal(split[0]), new BigDecimal(split[1]));
            }
        }
        List<Order> orders = orderMapper.selectByExample(orderExample);
        if (Objects.isNull(orders)) {
            orders = Lists.newArrayList();
        }
        return new PageInfo<>(orders);
    }
}
