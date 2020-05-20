package com.mongolia.controller;

import com.mongolia.model.vo.base.BaseResultVO;
import com.mongolia.model.vo.result.SuccessResultVO;
import com.mongolia.util.JWTUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Dong.w
 */
@RestController
@RequestMapping("/api")
public class CommonsController {

    @GetMapping("/app/tourists")
    public BaseResultVO touristsGetToken(){
        String token = JWTUtils.sign("guest", System.currentTimeMillis() + "mongolia");
        return new SuccessResultVO(token);
    }

}
