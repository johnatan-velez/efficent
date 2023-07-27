package com.epico.efficent.adapters.controller;

import java.util.List;

import com.epico.efficent.adapters.dto.UserDto;
import com.epico.efficent.domain.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralBasePaths.USER)
public class UserController
{
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("")
  public List<UserDto> user() {
    return userService.findAll();
  }
}
