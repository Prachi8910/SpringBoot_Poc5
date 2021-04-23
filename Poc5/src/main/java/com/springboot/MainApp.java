package com.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@Slf4j
@SpringBootApplication
public class MainApp {
	 
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
       //log.info("Springboot Pagination with Thymeleaf application is started successfully .");
    }
}