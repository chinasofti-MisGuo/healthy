package com.mongolia.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Report;
import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.factory.VoFactory;
import com.mongolia.model.vo.result.BackPageResultVO;
import com.mongolia.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理系统举报相关Api接口
 *
 * @author Dong.w
 */
@Slf4j
@RestController
@RequestMapping("/api/admin/report")
public class MsReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/list")
    public BaseResultVO reportList(@Valid PageDTO pageDTO) {
        PageInfo<Report> pageInfo = reportService.getList(pageDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), Report.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

    @GetMapping("/search")
    public BaseResultVO searchReport(@Valid SearchDTO searchDTO) {
        PageInfo<Report> pageInfo = reportService.reportListBySearch(searchDTO);
        List<Object> list = VoFactory.doBackwardList(pageInfo.getList(), Report.class);
        return new BackPageResultVO(pageInfo.getTotal(), list);
    }

}
