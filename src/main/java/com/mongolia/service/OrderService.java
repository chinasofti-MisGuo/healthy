package com.mongolia.service;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Order;

/**
 * 订单相关service接口
 * @author Dong.w
 */
public interface OrderService {

    /**
     * 所有订单
     * @param pageDTO   分页数据
     * @return  result page
     */
    PageInfo<Order> orderList(PageDTO pageDTO);

    /**
     * 搜索订单
     * @param searchDTO 搜索条件
     * @return  result page
     */
    PageInfo<Order> searchOrderList(SearchDTO searchDTO);
}
