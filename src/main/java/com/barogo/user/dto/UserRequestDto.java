package com.barogo.user.dto;

import com.barogo.common.validator.Password;
import com.barogo.user.domain.User;
import com.barogo.user.domain.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class UserRequestDto {
    @NotBlank
    @Size(max = 10)
    private String userId;
    @NotBlank
    @Size(max = 30, min = 12)
    @Password
    private String password;
    @NotBlank
    @Size(max = 10)
    private String userName;
    @NotNull
    @Size(max = 50)
    private String address;
    @NotNull
    @Size(max = 100)
    private String addressDetail;
    private UserStatus userStatus;

    public User toUser() {
        return User.builder()
                .userId(userId)
                .password(password)
                .name(userName)
                .address(address)
                .addressDetail(addressDetail)
                .build();
    }
}
