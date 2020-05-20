package com.mongolia.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.Problem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

/**
 * 问题相关DTO
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProblemDTO extends BaseDTO {

    private Integer id;

    @NotNull
    private String problem;

    @NotNull
    private String answer;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public Problem convertTo(){
        ProblemDtoConvert problemDtoConvert = new ProblemDtoConvert();
        return problemDtoConvert.doForward(this);
    }

    private static class ProblemDtoConvert extends BaseDtoConvert<ProblemDTO, Problem>{
        @Override
        protected Problem doForward(ProblemDTO problemDTO) {
            Problem problem = new Problem();
            if(Objects.nonNull(problemDTO)){
                BeanUtils.copyProperties(problemDTO, problem);
            }
            return problem;
        }

        @Override
        protected ProblemDTO doBackward(Problem problem) {
            ProblemDTO problemDTO = new ProblemDTO();
            if(Objects.nonNull(problem)){
                BeanUtils.copyProperties(problem, problemDTO);
            }
            return problemDTO;
        }
    }
}
