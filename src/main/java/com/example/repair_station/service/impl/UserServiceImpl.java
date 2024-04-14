package com.example.repair_station.service.impl;

import com.example.repair_station.config.JwtService;
import com.example.repair_station.dto.user.UserAuthRequest;
import com.example.repair_station.dto.user.UserAuthResponse;
import com.example.repair_station.dto.user.UserRequest;
import com.example.repair_station.dto.user.UserResponse;
import com.example.repair_station.entities.User;
import com.example.repair_station.enums.Role;
import com.example.repair_station.exception.BadRequestException;
import com.example.repair_station.exception.NotFoundException;
import com.example.repair_station.mapper.interfaces.UserMapper;
import com.example.repair_station.repositories.UserRepository;
import com.example.repair_station.service.interfaces.UserService;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public UserResponse getById(Long id, String token) {
        User actionUser = getUsernameFromToken(token);
        System.out.println(actionUser.getEmail());

        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new NotFoundException("user not found with id:"+id+"!", HttpStatus.BAD_REQUEST);
        return userMapper.toDto(user.get());
    }
    @Override
    public User getUsernameFromToken(String token) {

        String[] chunks = token.substring(7).split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();

        JSONParser jsonParser = new JSONParser();
        JSONObject object = null;
        try {
            object = (JSONObject) jsonParser.parse(decoder.decode(chunks[1]));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return userRepository.findByEmail(String.valueOf(object.get("sub"))).orElseThrow(() -> new RuntimeException("user can be null"));
    }

    @Override
    public void deleteById(Long id) {
        if (userRepository.findById(id).isEmpty())
            throw new NotFoundException("user not found with id:"+id+"!", HttpStatus.BAD_REQUEST);
        userRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, UserRequest userRequest) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new NotFoundException("user not found with id:"+id+"!", HttpStatus.BAD_REQUEST);


        userRepository.save(user.get());
    }


    @Override
    public List<UserResponse> getAll() {
        return userMapper.toDtoS(userRepository.findAll());
    }

}