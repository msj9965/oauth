package com.example.oauth.member.dto;

import com.example.oauth.member.domain.Role;
import com.example.oauth.member.domain.SocialType;
import lombok.Data;
import lombok.Getter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.oauth.member.domain.Member}
 */
@Value
public class MemberCreateDto implements Serializable {
    Long id;
    String email;
    String password;
    Role role;
    SocialType socialType;
    String socialId;
}