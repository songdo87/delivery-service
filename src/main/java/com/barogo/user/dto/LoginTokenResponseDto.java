package com.barogo.user.dto;

import com.barogo.common.validator.Password;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class LoginTokenResponseDto {
    private String token;
}
