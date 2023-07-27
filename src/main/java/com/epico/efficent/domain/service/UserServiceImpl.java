package com.epico.efficent.domain.service;

import java.util.List;

import com.epico.efficent.adapters.dto.UserDto;
import com.epico.efficent.adapters.repository.UserRepository;
import com.epico.efficent.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl
    implements UserService
{
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public List<UserDto> findAll() {
    List<User> users = (List<User>) userRepository.findAll();
    return users.stream().map(this::convertToDto).toList();
  }

  @Override
  public User findById(Long id) {
    return null;
  }

  @Override
  public User findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public User findByEmailAndPassword(String email, String password) {
    return null;
  }

  @Override
  public User update(User user) {
    return null;
  }

  @Override
  public User delete(Long id) {
    return null;
  }

  private UserDto convertToDto(User user) {
    UserDto userDto = new UserDto();
    userDto.setId(user.getId().toString());
    userDto.setEmail(user.getEmail());
    userDto.setPassword(user.getPassword());
    return userDto;
  }

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    User user = findByEmail(username);
    if (user != null) {
      return convertToUserDetails(user);
    }

    throw new UsernameNotFoundException("User '" + username + "' not found");
  }

  private UserDetails convertToUserDetails(User user) {
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
}
