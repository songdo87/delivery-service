package com.barogo.user.repository;

import com.barogo.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserId(String userId);
    Optional<User> findUserByUserIdAndPassword(String userId, String password);
}