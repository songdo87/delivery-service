package com.barogo.user.ui;

import com.barogo.user.application.UserService;
import com.barogo.user.domain.User;
import com.barogo.user.dto.LoginRequestDto;
import com.barogo.user.dto.LoginTokenResponseDto;
import com.barogo.user.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid UserRequestDto userRequestDto) {
        userService.create(userRequestDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginTokenResponseDto> login(@RequestBody @Valid LoginRequestDto loginDto) {
        String token = userService.login(loginDto);
        return ResponseEntity.ok().body(new LoginTokenResponseDto(token));
    }
}