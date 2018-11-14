package com.mmall.controller.test;

import com.mmall.service.impl.CategoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author WangCH
 * @create 2018-02-12 21:34
 */
@Controller
@RequestMapping("/test/")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @RequestMapping(value = "test.do")
    @ResponseBody
    public String test(String str){
        logger.info("testinfo");
        logger.warn("testwarn");
        logger.error("testerror");
        return "testvalue:"+str;
    }
}
