package com.ohgiraffers.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Chap0102EurekaClientLectureSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chap0102EurekaClientLectureSourceApplication.class, args);
	}

}
