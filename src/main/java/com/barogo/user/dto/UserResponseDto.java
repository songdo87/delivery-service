package com.barogo.user.dto;

import com.barogo.common.validator.Password;
import com.barogo.user.domain.User;
import com.barogo.user.domain.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class UserResponseDto {
    private String userId;
    private String password;
    private String userName;
    private String address;
    private String addressDetail;
    private UserStatus userStatus;
    private String token;
}
