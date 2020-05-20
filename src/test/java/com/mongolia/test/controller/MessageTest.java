package com.mongolia.test.controller;

import com.google.gson.Gson;
import com.mongolia.controller.admin.MsMessageController;
import com.mongolia.model.dto.PageDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author Dong.w
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:springmvc/spring-mvc.xml"})
public class MessageTest {

//    @Autowired
//    private MsMessageController messageController;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setUp()throws Exception{
//        mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();
//    }

    @Test
    public void getListTest()throws Exception{
        System.out.println(1);
//        PageDTO dto = new PageDTO();
//        dto.setPage(1);
//        dto.setLimit(2);
//        Gson gson = new Gson();
//        RequestBuilder builder = MockMvcRequestBuilders
//                .get("/api/admin/message/list")
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(gson.toJson(dto));
//        MvcResult result = mockMvc.perform(builder).andReturn();
//        System.out.println(result.getAsyncResult());
    }

}
