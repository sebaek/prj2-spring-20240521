package com.prj2spring20240521.domain.member;

import lombok.Data;

@Data
public class Member {
    private String email;
    private String password;
    private String nickName;
}
