package com.ohgiraffers.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication

/* 설명. eureka 서버의 자격을 등록(서비스 디스커버리로써 지금 프로젝트를 기동) */
@EnableEurekaServer
public class Chap0101EurekaServerLectureSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap0101EurekaServerLectureSourceApplication.class, args);
    }

}
