package com.epico.efficent.adapters.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable {
    private String id;
    private String email;
    private String password;
}
