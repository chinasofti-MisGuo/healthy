package com.mongolia.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mongolia.dao.ProblemMapper;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Problem;
import com.mongolia.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 问题相关Service相关实现
 * @author Dong.w
 */
@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public PageInfo<Problem> getList(PageDTO pageDTO) {
        List<Problem> list = problemMapper.selectAll();
        if(Objects.isNull(list) || list.isEmpty()){
            list = Lists.newArrayList();
        }
        return new PageInfo<>(list);
    }

    @Override
    public int addProblem(Problem problem) {
        problem.setCreateTime(new Date());
        return problemMapper.insertSelective(problem);
    }

    @Override
    public int editProblem(Problem problem) {
        problem.setUpdateTime(new Date());
        return problemMapper.updateByPrimaryKeySelective(problem);
    }

    @Override
    public int deleteProblem(BaseDataDTO baseDataDTO) {
        Problem problem = new Problem();
        problem.setId(baseDataDTO.getId());
        problem.setIsDel(Short.valueOf("1"));
        problem.setUpdateTime(new Date());
        return problemMapper.updateByPrimaryKeySelective(problem);
    }

    @Override
    public PageInfo<Problem> getSearchList(SearchDTO searchDTO) {
        List<Problem> resultList = problemMapper.selectByExample(searchDTO);
        if(Objects.isNull(resultList) || resultList.isEmpty()){
            resultList = Lists.newArrayList();
        }
        return new PageInfo<>(resultList);
    }

    @Override
    public List<Problem> appGetProblem() {
        List<Problem> list = problemMapper.selectAll();
        if (Objects.isNull(list)) {
            list = Lists.newArrayList();
        }
        return list;
    }
}
