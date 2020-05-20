package com.mongolia.test;

import com.mongolia.model.entity.Message;
import org.junit.Test;

import java.util.Date;

/**
 * @author Dong.w
 */
public class VOFactoryTest {

    @Test
    public void backTest()throws Exception{
        Message message = new Message();
        message.setId(1L);
        message.setCreateTime(new Date());
//        Optional optional = VoFactory.getInstance().doBackWard(message);

//        System.out.println(optional.get());
    }

}
