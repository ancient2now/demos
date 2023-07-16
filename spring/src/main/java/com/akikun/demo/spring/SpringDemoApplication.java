package com.akikun.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 李俊秋(龙泽)
 */
@EnableScheduling
@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间：" + LocalDateTime.now().format(formatter));

        SpringApplication.run(SpringDemoApplication.class);
    }
}
