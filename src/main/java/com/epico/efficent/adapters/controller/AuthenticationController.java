package com.epico.efficent.adapters.controller;

import com.epico.efficent.adapters.dto.request.AuthenticationRequestDto;
import com.epico.efficent.adapters.dto.response.AuthenticationResponse;
import com.epico.efficent.domain.service.UserService;
import com.epico.efficent.infrastructure.security.jwt.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralBasePaths.LOGIN)
public class AuthenticationController
{
  private final AuthenticationManager authenticationManager;

  private final UserService userService;

  private final JwtUtil jwtUtil;

  public AuthenticationController(
      AuthenticationManager authenticationManager,
      UserService userService,
      JwtUtil jwtUtil)
  {
    this.authenticationManager = authenticationManager;
    this.userService = userService;
    this.jwtUtil = jwtUtil;
  }

  @PostMapping("")
  public ResponseEntity<?> login(@RequestBody AuthenticationRequestDto authRequest) throws Exception {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
    }
    catch (BadCredentialsException e) {
      throw new Exception("Incorrect username or password", e);
    }

    final UserDetails userDetails = userService.loadUserByUsername(authRequest.getEmail());

    final String jwt = jwtUtil.generateTokenFromUsername(userDetails.getUsername());

    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }
}
