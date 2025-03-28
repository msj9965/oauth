package com.example.oauth.member.dto;

import com.example.oauth.member.domain.Role;
import com.example.oauth.member.domain.SocialType;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.oauth.member.domain.Member}
 */
@Value
@Data
public class MemberLoginDto implements Serializable {
    Long id;
    String email;
    String password;
    Role role;
    SocialType socialType;
    String socialId;
}