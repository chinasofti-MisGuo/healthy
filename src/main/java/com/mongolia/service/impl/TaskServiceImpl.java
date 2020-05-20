package com.mongolia.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mongolia.dao.TaskMapper;
import com.mongolia.model.dto.PageDTO;
import com.mongolia.model.dto.SearchDTO;
import com.mongolia.model.entity.Task;
import com.mongolia.model.enums.StateType;
import com.mongolia.model.example.TaskExample;
import com.mongolia.service.TaskService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 任务相关实现
 * @author Dong.w
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public PageInfo<Task> taskList(PageDTO pageDTO) {
        TaskExample taskExample = new TaskExample();
        taskExample.setOrderByClause("id DESC");
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        if(Objects.isNull(tasks)){
            tasks = Lists.newArrayList();
        }
        return new PageInfo<>(tasks);
    }

    @Override
    public PageInfo<Task> searchTaskList(SearchDTO searchDTO) {
        TaskExample taskExample = new TaskExample();
        taskExample.setOrderByClause("id DESC");
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andIsDelEqualTo(StateType.NO.getValue());
        if (StringUtils.isNotEmpty(searchDTO.getName())) {
            criteria.andNameEqualTo(searchDTO.getName());
        }
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        if (Objects.isNull(tasks)) {
            tasks = Lists.newArrayList();
        }
        return new PageInfo<>(tasks);
    }

    @Override
    public boolean editTask(Task task) {
        task.setUpdateTime(new Date());
        int result = taskMapper.updateByPrimaryKeySelective(task);
        return (result == 1);
    }

    @Override
    public List<Task> taskAll() {
        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andIsDelEqualTo(StateType.NO.getValue());
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        if (Objects.isNull(tasks)) {
            tasks = Lists.newArrayList();
        }
        return tasks;
    }
}
