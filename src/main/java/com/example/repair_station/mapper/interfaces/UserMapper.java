package com.example.repair_station.mapper.interfaces;

import com.example.repair_station.dto.user.UserResponse;
import com.example.repair_station.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserMapper {
    UserResponse toDto(User user);

    List<UserResponse> toDtoS(List<User> all);
}