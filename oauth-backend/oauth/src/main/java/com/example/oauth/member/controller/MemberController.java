package com.example.oauth.member.controller;

import com.example.oauth.common.auth.JwtTokenProvider;
import com.example.oauth.member.domain.Member;
import com.example.oauth.member.dto.MemberCreateDto;
import com.example.oauth.member.dto.MemberLoginDto;
import com.example.oauth.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/create")
    public ResponseEntity<?> memberCreate(@RequestBody MemberCreateDto memberCreateDto) {
        Member member = memberService.create(memberCreateDto);
        return new ResponseEntity<>(member.getId(), HttpStatus.CREATED);
    }

    @PostMapping("/dologin")
    public ResponseEntity<?>doLogin(@RequestBody MemberLoginDto memberLoginDto){
        // email, password 일치하는지 검증
        Member member = memberService.login(memberLoginDto);
        //일치할 경우 jwt access token 발급
        String jwtToken = jwtTokenProvider.createToken(member.getEmail(), member.getRole().toString());

        Map<String, Object> loginInfo = new HashMap<>();
        loginInfo.put("token", jwtToken);

        return new ResponseEntity<>(loginInfo, HttpStatus.OK);

    }


}
