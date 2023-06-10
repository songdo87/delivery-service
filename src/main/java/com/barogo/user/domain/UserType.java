package com.barogo.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserType {
    MEMBER("회원"),
    ADMIN("관리자")
    ;

    private final String description;
}