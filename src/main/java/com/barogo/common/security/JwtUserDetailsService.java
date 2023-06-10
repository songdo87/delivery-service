package com.barogo.common.security;

import com.barogo.user.domain.User;
import com.barogo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("find not user info"));

        return User.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .password(user.getPassword())
                .name(user.getName())
                .build();
    }
}
