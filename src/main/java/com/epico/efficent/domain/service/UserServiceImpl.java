package com.epico.efficent.domain.service;

import java.util.List;

import com.epico.efficent.adapters.dto.request.UserRequest;
import com.epico.efficent.adapters.dto.response.UserResponse;
import com.epico.efficent.adapters.repository.UserRepository;
import com.epico.efficent.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl
    implements UserService
{
  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;

  public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public UserResponse save(UserRequest userRequest) {
    User user = convertToUser(userRequest);
    return convertToDto(userRepository.save(user));
  }

  @Override
  public List<UserResponse> findAll() {
    List<com.epico.efficent.domain.entity.User> users =
        (List<com.epico.efficent.domain.entity.User>) userRepository.findAll();
    return users.stream().map(this::convertToDto).toList();
  }

  @Override
  public UserResponse findById(Long id) {
    return null;
  }

  @Override
  public UserResponse findByEmail(String email) {
    return convertToDto(userRepository.findByEmail(email));
  }

  @Override
  public UserResponse findByEmailAndPassword(String email, String password) {
    return null;
  }

  @Override
  public UserResponse update(com.epico.efficent.domain.entity.User user) {
    return null;
  }

  @Override
  public UserResponse delete(Long id) {
    return null;
  }

  private UserResponse convertToDto(com.epico.efficent.domain.entity.User user) {
    UserResponse userResponse = new UserResponse();
    userResponse.setId(user.getId().toString());
    userResponse.setEmail(user.getEmail());
    userResponse.setPassword(user.getPassword());
    return userResponse;
  }

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    UserResponse userResponse = findByEmail(username);
    if (userResponse != null) {
      return convertToUserDetails(userResponse);
    }

    throw new UsernameNotFoundException("User '" + username + "' not found");
  }

  private UserDetails convertToUserDetails(com.epico.efficent.domain.entity.User user) {
    return org.springframework.security.core.userdetails.User
        .withUsername(user.getEmail())
        .password(user.getPassword())
        .authorities("USER")
        .accountExpired(false)
        .accountLocked(false)
        .credentialsExpired(false)
        .disabled(false)
        .build();
  }

  private User convertToUser(UserRequest userRequest) {
    User user = new User();
    user.setEmail(userRequest.getEmail());
    user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
    return user;
  }
}
