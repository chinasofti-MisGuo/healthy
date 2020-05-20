package com.mongolia.service;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.BaseDataDTO;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Problem;

import java.util.List;

/**
 * 问题相关Service
 * @author Dong.w
 */
public interface ProblemService {

    /**
     * 获取常见问题列表
     * @return  result
     */
    PageInfo<Problem> getList(PageDTO pageDTO);

    /**
     * 添加常见问题
     * @param problem   问题实体
     * @return  result
     */
    int addProblem(Problem problem);

    /**
     * 编辑常见问题
     * @param problem   问题实体
     * @return  result
     */
    int editProblem(Problem problem);

    /**
     * 删除常见问题
     * @param baseDataDTO   删除条件
     * @return  result
     */
    int deleteProblem(BaseDataDTO baseDataDTO);

    /**
     * 搜索问题
     * @param searchDTO 搜索条件
     * @return  result
     */
    PageInfo<Problem> getSearchList(SearchDTO searchDTO);

    /**
     * app端问题
     * @return  result list
     */
    List<Problem> appGetProblem();
}
