package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.Comment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 评论请求数据
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CommentDTO extends BaseDTO implements Serializable {

    @NotNull
    @Min(1)
    private Long uid;

    @NotNull
    @Min(1)
    private Long comId;

    @NotNull
    private String content;

    private Long baseId;

    public Comment convertToComment(){
        CommentDtoConvert commentDtoConvert = new CommentDtoConvert();
        return commentDtoConvert.doForward(this);
    }

    private static class CommentDtoConvert extends BaseDtoConvert<CommentDTO, Comment>{
        @Override
        protected Comment doForward(CommentDTO commentDTO) {
            Comment comment = new Comment();
            BeanUtils.copyProperties(commentDTO, comment);
            return comment;
        }

        @Override
        protected CommentDTO doBackward(Comment comment) {
            return null;
        }
    }
}
