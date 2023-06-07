package com.spring3.practice.repository;

import com.spring3.practice.security.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepo extends JpaRepository<UserInfo,Integer> {

    Optional<UserInfo> findByName(String name);
}
