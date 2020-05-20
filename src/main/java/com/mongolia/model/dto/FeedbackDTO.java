package com.mongolia.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.Feedback;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

/**
 * 意见反馈DTO
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FeedbackDTO extends BaseDTO {

    private Long id;

    private String phone;

    private String content;

    private String reply;

    private Long replyId;

    private Short state;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String username;


    public Feedback convertTo(){
        FeedbackDtoConvert feedbackDtoConvert = new FeedbackDtoConvert();
        return feedbackDtoConvert.doForward(this);
    }

    private static class FeedbackDtoConvert extends BaseDtoConvert<FeedbackDTO, Feedback>{
        @Override
        protected Feedback doForward(FeedbackDTO feedbackDTO) {
            Feedback feedback = new Feedback();
            if(Objects.nonNull(feedbackDTO)){
                BeanUtils.copyProperties(feedbackDTO, feedback);
            }
            return feedback;
        }

        @Override
        protected FeedbackDTO doBackward(Feedback feedback) {
            FeedbackDTO feedbackDTO = new FeedbackDTO();
            if(Objects.nonNull(feedback)){
                BeanUtils.copyProperties(feedback, feedbackDTO);
            }
            return feedbackDTO;
        }
    }
}
