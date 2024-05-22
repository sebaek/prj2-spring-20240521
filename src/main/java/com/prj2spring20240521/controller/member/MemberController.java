package com.prj2spring20240521.controller.member;

import com.prj2spring20240521.domain.member.Member;
import com.prj2spring20240521.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    final MemberService service;

    @PostMapping("signup")
    public void signup(@RequestBody Member member) {
        service.add(member);
    }
}
