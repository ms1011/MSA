package com.ohgiraffers.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Chap0402OrderServiceLectureSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap0402OrderServiceLectureSourceApplication.class, args);
    }

}
