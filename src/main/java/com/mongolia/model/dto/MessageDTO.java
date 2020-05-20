package com.mongolia.model.dto;

import com.mongolia.model.dto.base.BaseDTO;
import com.mongolia.model.dto.base.BaseDtoConvert;
import com.mongolia.model.entity.Message;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

/**
 * @author Dong.w
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MessageDTO extends BaseDTO {

    private Long id;

    @NotNull
    private String msgTitle;

    @NotNull
    private String msgBriefly;

    @NotNull
    private String msgContent;

    private String receive;

    public Message convertToMessage(){
        MessageDtoConvert messageDtoConvert = new MessageDtoConvert();
        return messageDtoConvert.doForward(this);
    }

    private static class MessageDtoConvert extends BaseDtoConvert<MessageDTO, Message>{
        @Override
        protected Message doForward(MessageDTO messageDTO) {
            Message message = new Message();
            BeanUtils.copyProperties(messageDTO, message);
            return message;
        }

        @Override
        protected MessageDTO doBackward(Message message) {
            MessageDTO messageDTO = new MessageDTO();
            BeanUtils.copyProperties(message, messageDTO);
            return messageDTO;
        }
    }
}
