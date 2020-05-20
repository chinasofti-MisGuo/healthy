package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.Task;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 任务相关请求数据
 * @author Dong.w
 */
@Data
public class TaskDTO implements Serializable {

    @NotNull
    @Min(1)
    private Integer id;

    @NotNull
    @Min(1)
    private Integer integral;

    @NotNull
    @Min(1)
    private Integer integralOfDay;

    @NotNull
    private String detail;

    public Task convertToTask(){
        TaskDtoConvert taskDtoConvert = new TaskDtoConvert();
        return taskDtoConvert.doForward(this);
    }

    private static class TaskDtoConvert extends BaseDtoConvert<TaskDTO, Task>{
        @Override
        protected Task doForward(TaskDTO taskDTO) {
            Task task = new Task();
            BeanUtils.copyProperties(taskDTO, task);
            return task;
        }

        @Override
        protected TaskDTO doBackward(Task task) {
            return null;
        }
    }
}
