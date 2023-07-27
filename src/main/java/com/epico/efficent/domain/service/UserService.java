package com.epico.efficent.domain.service;

import java.util.List;

import com.epico.efficent.adapters.dto.request.UserRequest;
import com.epico.efficent.adapters.dto.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService
    extends UserDetailsService
{
  UserResponse save(UserRequest user);

  List<UserResponse> findAll();

  UserResponse findById(Long id);

  UserResponse findByEmail(String email);

  UserResponse findByEmailAndPassword(String email, String password);

  UserResponse update(com.epico.efficent.domain.entity.User user);

  UserResponse delete(Long id);
}
