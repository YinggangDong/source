package com.dyg.source.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LogExample 类是 log4j2测试类
 *
 * @author dongyinggang
 * @date 2020-09-17 14:58
 **/
@Slf4j
@RestController
public class LogExample {

    @GetMapping("/test")
    public void test(){
        log.trace("this is trace log");
        log.debug("this is debug log");
        log.info("this is info log");
        log.error("为啥只打error级别");
        log.warn("this is warn log");
    }
}
