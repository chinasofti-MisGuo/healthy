package com.mongolia.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mongolia.model.entity.Message;
import com.mongolia.model.vo.base.BaseVoConvert;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.Objects;

/**
 * 消息回传数据
 *
 * @author Dong.w
 */
@Data
public class MessageVO {

    private Long id;

    private String msgTitle;

    private String msgBriefly;

    private String msgContent;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private static class MessageVoConvert extends BaseVoConvert<Message, MessageVO>{
        @Override
        protected Message doForward(MessageVO messageVO) {
            Message message = new Message();
            if (Objects.nonNull(messageVO)) {
                BeanUtils.copyProperties(messageVO, message);
            }
            return message;
        }

        @Override
        protected MessageVO doBackward(Message message) {
            MessageVO messageVO = new MessageVO();
            if(Objects.nonNull(message)){
                BeanUtils.copyProperties(message, messageVO);
            }
            return messageVO;
        }
    }

}
