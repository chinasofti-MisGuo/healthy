package com.mongolia.service.impl;

import com.google.common.collect.Lists;
import com.mongolia.dao.IntegralRuleMapper;
import com.mongolia.model.entity.IntegralRule;
import com.mongolia.service.IntegralRuleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Dong.w
 */
@Service
public class IntegralRuleServiceImpl implements IntegralRuleService {

    @Autowired
    private IntegralRuleMapper integralRuleMapper;

    @Override
    public List<IntegralRule> allRule() {
        IntegralRule integralRule = integralRuleMapper.selectByPrimaryKey(1);
        return Lists.newArrayList(integralRule);
    }

    @Override
    public int addIntegralRule(IntegralRule rule) {
        return ruleEdit(rule);
    }

    @Override
    public int editIntegralRule(IntegralRule rule) {
        return ruleEdit(rule);
    }

    private int ruleEdit(IntegralRule rule) {
        IntegralRule integralRule = integralRuleMapper.selectByPrimaryKey(1);
        if(Objects.isNull(integralRule)) {
            rule.setCreateTime(new Date());
            return integralRuleMapper.insertSelective(rule);
        }else{
            integralRule.setUpdateTime(new Date());
            if(StringUtils.isNotEmpty(rule.getProportion())) {
                integralRule.setProportion(rule.getProportion());
            }
            if(StringUtils.isNotEmpty(rule.getDescription())) {
                integralRule.setDescription(rule.getDescription());
            }
            return integralRuleMapper.updateByPrimaryKeySelective(integralRule);
        }
    }
}
