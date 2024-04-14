package com.example.repair_station.service.interfaces;

import com.example.repair_station.dto.user.UserAuthRequest;
import com.example.repair_station.dto.user.UserAuthResponse;
import com.example.repair_station.dto.user.UserRequest;
import com.example.repair_station.dto.user.UserResponse;
import com.example.repair_station.entities.User;

import java.util.List;

public interface UserService {

    UserResponse getById(Long id, String t);

    User getUsernameFromToken(String token);

    void deleteById(Long id);

    void updateById(Long id, UserRequest userRequest);

    List<UserResponse> getAll();
}