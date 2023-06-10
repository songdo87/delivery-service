package com.barogo.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserStatus {
    NORMAL("정상"),
    PAUSE("휴먼"),
    STOP("탈퇴"),
    ;

    private final String description;

}
