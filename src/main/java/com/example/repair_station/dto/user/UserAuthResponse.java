package com.example.repair_station.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthResponse {
    private String email;
    private String token;
    private String role;
}