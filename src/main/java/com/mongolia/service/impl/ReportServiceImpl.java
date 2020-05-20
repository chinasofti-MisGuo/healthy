package com.mongolia.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mongolia.dao.ReportMapper;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Report;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.ReportExample;
import com.mongolia.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 举报相关Service实现
 * @author Dong.w
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public PageInfo<Report> getList(PageDTO pageDTO) {
        ReportExample reportExample = new ReportExample();
        reportExample.setOrderByClause("id DESC");
        ReportExample.Criteria criteria = reportExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<Report> reports = reportMapper.selectByExample(reportExample);
        if (Objects.isNull(reports)) {
            reports = Lists.newArrayList();
        }
        return new PageInfo<>(reports);
    }

    @Override
    public PageInfo<Report> reportListBySearch(SearchDTO searchDTO) {
        List<Report> list = reportMapper.selectByCondition(searchDTO);
        if (Objects.isNull(list)) {
            list = Lists.newArrayList();
        }
        return new PageInfo<>(list);
    }

    @Override
    public boolean addReport(Report report) {
        int result = reportMapper.insertSelective(report);
        return (result == 1);
    }
}
