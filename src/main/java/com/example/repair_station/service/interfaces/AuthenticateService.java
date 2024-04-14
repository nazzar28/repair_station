package com.example.repair_station.service.interfaces;

import com.example.repair_station.dto.user.UserAuthRequest;
import com.example.repair_station.dto.user.UserAuthResponse;
import com.example.repair_station.entities.User;

import javax.management.relation.Relation;

public interface AuthenticateService {
    void register(UserAuthRequest userAuthRequest);

    UserAuthResponse login(UserAuthRequest userAuthRequest);

    User getUsernameFromToken(String token);
}
