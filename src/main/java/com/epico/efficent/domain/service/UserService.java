package com.epico.efficent.domain.service;

import java.util.List;

import com.epico.efficent.adapters.dto.UserDto;
import com.epico.efficent.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService
    extends UserDetailsService
{
  User save(User user);

  List<UserDto> findAll();

  User findById(Long id);

  User findByEmail(String email);

  User findByEmailAndPassword(String email, String password);

  User update(User user);

  User delete(Long id);
}
