package com.example.bank.service;

import com.example.bank.repository.UserRepository;
import com.example.bank.entity.User;
import com.example.bank.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        List<User> allUsers = userRepository.findAll();
        List<UserDTO> allUsersDTO = new ArrayList<>();
        allUsers.forEach(user -> allUsersDTO.add(toUserDTO(user)));
        return allUsersDTO;
    }

    public UserDTO findById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return null;
        }
        UserDTO userDTO = toUserDTO(optionalUser.get());
        return userDTO;
    }

    @Override
    public List<UserDTO> findAllByLoginContainsIgnoreCase(String login) {
        List<User> allUsers = userRepository.findAllByLoginContainsIgnoreCase(login);
        List<UserDTO> allUsersDTO = new ArrayList<>();
        allUsers.forEach(user -> allUsersDTO.add(toUserDTO(user)));
        return allUsersDTO;
    }

    //TODO is it correct to use "save" method? Maybe saveAndFlush will be better solution
    public UserDTO save(UserDTO userDTO) {
        User savedUser = userRepository.save(toUser(userDTO));
        UserDTO savedUserDTO = toUserDTO(savedUser);
        return savedUserDTO;
    }
//TODO "delete" method returns void. Want to return deleted object.
// Invoking "findById" inside "delete". Not sure if it is OK.
    @Override
    public UserDTO delete(Integer id) {
        UserDTO deletedUserDTO = findById(id);
        userRepository.deleteById(id);
        return deletedUserDTO;
    }

    private UserDTO toUserDTO(User user) {
        return new UserDTO(user.getId(), user.getLogin());
    }

    private User toUser(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getLogin());
    }
}
