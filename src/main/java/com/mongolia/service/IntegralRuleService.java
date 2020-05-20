package com.mongolia.service;

import com.mongolia.model.entity.IntegralRule;

import java.util.List;

/**
 * 积分相关Service接口
 * @author Dong.w
 */
public interface IntegralRuleService {

    /**
     * 积分规则列表
     * @return  list
     */
    List<IntegralRule> allRule();

    /**
     * 添加规则
     * @param rule  规则实体
     * @return  result
     */
    int addIntegralRule(IntegralRule rule);

    /**
     * 编辑规则
     * @param rule 规则数据实体
     * @return  result
     */
    int editIntegralRule(IntegralRule rule);

}
