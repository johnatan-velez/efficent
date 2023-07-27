package com.epico.efficent.adapters.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto
    implements Serializable
{
  private String id;

  private String email;

  private String password;
}
