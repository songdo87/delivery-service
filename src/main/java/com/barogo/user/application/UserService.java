package com.barogo.user.application;

import com.barogo.common.security.JwtTokenProvider;
import com.barogo.user.domain.User;
import com.barogo.user.dto.LoginRequestDto;
import com.barogo.user.dto.UserRequestDto;
import com.barogo.user.exception.UserValidateException;
import com.barogo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    /**
     * 회원가입 필수체크 - Dto 에서 처리
     * Password 유효성 검사 - 정규식으로 유효성 검사
     * 데이터 길이 - Entity 에서 지정 하여 Dto 에서 길이 제한 처리
     * @param userRequestDto
     * @throws Exception
     */
    @Transactional
    public void create(UserRequestDto userRequestDto) {
        validateDuplicateUserId(userRequestDto.getUserId());
        userRepository.save(userRequestDto.toUser());
    }

    /**
     * 로그인필터와 실제 인증을 진행하는 권한체크필터 사이에
     * JWT 토큰을 검증해주는 jwt 권한 필터를 만들어 로그인 인증을 처리한다.
     * 실제 jwtTokenProvider 에서 Access Token 을 발행한다.
     * @param loginDto
     * @return UserDto
     * @throws LoginException
     */
    public String login(LoginRequestDto loginDto) {
        User user = userRepository
                .findUserByUserIdAndPassword(loginDto.getUserId(), loginDto.getPassword())
                .orElseThrow(UserValidateException::new);

        return jwtTokenProvider.createToken(user.getUserId());
    }

    private void validateDuplicateUserId(String userId) {
        if (userRepository.findUserByUserId(userId).isPresent()) {
            throw new UserValidateException();
        }
    }
}