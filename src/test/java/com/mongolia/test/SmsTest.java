package com.mongolia.test;

import com.mongolia.component.SmsTemplate;
import org.junit.Test;

/**
 * @author Dong.w
 */
public class SmsTest {

    SmsTemplate smsTemplate = new SmsTemplate();

    @Test
    public void codeTest() throws Exception{
        smsTemplate.init();
        smsTemplate.sendCode("17320289585");
    }

}
