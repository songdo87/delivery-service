package com.barogo.delivery.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DeliveryStatus {
    WAITING("배달 준비중"),
    STARTING("배달 시작됨"),
    COMPLETE("배달 완료됨"),
    ;

    private final String description;
}