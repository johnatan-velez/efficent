package com.epico.efficent.adapters.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserRequest
{
  @NotNull
  @Email
  @Length(min = 5, max = 50)
  private String email;

  @NotNull
  @Length(min = 5, max = 50)
  private String password;

  @NotNull
  private String name;

  @NotNull
  private String username;
}
