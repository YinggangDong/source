package com.dyg.source;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SourceApplication {

    public static void main(String[] args) {
        log.info("hello spring");
        SpringApplication.run(SourceApplication.class, args);
    }

}
