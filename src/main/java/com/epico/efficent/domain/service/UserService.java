package com.epico.efficent.domain.service;

import com.epico.efficent.adapters.dto.UserDto;
import com.epico.efficent.domain.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<UserDto> findAll();

    User findById(Long id);

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    User update(User user);

    User delete(Long id);
}
