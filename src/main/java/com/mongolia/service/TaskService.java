package com.mongolia.service;

import com.github.pagehelper.PageInfo;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Task;

import java.util.List;

/**
 * 任务相关Service接口
 * @author Dong.w
 */
public interface TaskService {

    /**
     * 任务列表
     * @param pageDTO   分页数据
     * @return  result page
     */
    PageInfo<Task> taskList(PageDTO pageDTO);

    /**
     * 搜索任务
     * @param searchDTO 搜索条件
     * @return  result page
     */
    PageInfo<Task> searchTaskList(SearchDTO searchDTO);

    /**
     * 编辑任务
     * @param task  任务数据
     * @return  result
     */
    boolean editTask(Task task);

    /**
     * 全部任务
     * @return  result
     */
    List<Task> taskAll();

}
