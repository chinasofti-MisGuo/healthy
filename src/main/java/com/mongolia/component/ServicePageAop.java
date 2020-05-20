package com.mongolia.component;

import com.github.pagehelper.PageHelper;
import com.mongolia.model.dto.PageDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Objects;


/**
 * 服务层分页AOP
 * @author Dong.w
 */
@Slf4j
@Aspect
@Component
public class ServicePageAop {

    /**
     * 分页切点
     */
    @Pointcut("execution(* com.mongolia.service.*.*List*(..))")
    public void point(){}

    @Before("point()")
    public void startPage(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        if(StringUtils.equals("indexGetList", name)){
            PageHelper.startPage(1,5);
        }else{
            Object[] args = joinPoint.getArgs();
            for (Object o : args){
                if(o instanceof PageDTO){
                    PageDTO page = (PageDTO) o;
                    if(Objects.nonNull(page.getPage()) && Objects.nonNull(page.getLimit())) {
                        PageHelper.startPage(page.getPage(), page.getLimit());
                    }
                }
            }
        }
    }
}
