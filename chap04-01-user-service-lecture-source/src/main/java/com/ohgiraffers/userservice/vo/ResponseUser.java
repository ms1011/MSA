package com.ohgiraffers.userservice.vo;

import lombok.Data;

import java.util.List;

@Data
public class ResponseUser {
    private String name;            // 사용자 이름
    private String email;           // 사용자 이메일
    private String userId;          // 사용자 id(회원번호 아님)

    /* 설명. FeignClient 이후(다른 도메인 서버와 통신해서 값을 가져온 이후) 추가할 것 */
//    private List<ResponseUser> orders;
}
