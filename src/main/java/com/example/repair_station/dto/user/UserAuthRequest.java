package com.example.repair_station.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthRequest {
    private String email;
    private String password;
    private String role;
}