package com.mongolia.service;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Report;

/**
 * 举报相关Service接口
 * @author Dong.w
 */
public interface ReportService {

    /**
     * 举报信息列表
     * @param pageDTO   分页数据
     * @return  result page
     */
    PageInfo<Report> getList(PageDTO pageDTO);

    /**
     * 搜索举报信息
     * @param searchDTO 搜索条件
     * @return  result page
     */
    PageInfo<Report> reportListBySearch(SearchDTO searchDTO);

    /**
     * 添加举报
     * @param report    举报内容
     * @return  result
     */
    boolean addReport(Report report);
}
