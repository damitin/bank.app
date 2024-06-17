package com.example.bank.service;

import com.example.bank.model.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();

    UserDTO findById(Integer id);

    List<UserDTO> findAllByLoginContainsIgnoreCase(String login);

    UserDTO save(UserDTO userDTO);

    UserDTO delete(Integer id);
}
