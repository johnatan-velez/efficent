package com.epico.efficent.adapters.dto.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticationResponse
{
  private final String id;

  private final String email;

  private final String jwt;
}
