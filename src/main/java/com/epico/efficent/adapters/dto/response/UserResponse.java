package com.epico.efficent.adapters.dto.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse
    implements Serializable
{
  private String id;

  private String email;

  private String password;
}
