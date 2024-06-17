package com.example.bank.controller;

import com.example.bank.exception.UserNotFoundException;
import com.example.bank.model.UserDTO;
import com.example.bank.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //TODO can be switched to POST to support any number of parameters
    @GetMapping()
    public List<UserDTO> findAll(
            @RequestParam(required = false, defaultValue = "") String login
    ) {
        List<UserDTO> allUsers = userService.findAllByLoginContainsIgnoreCase(login);
        return allUsers;
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Integer id) {
        UserDTO userDTO = userService.findById(id);
        if (userDTO == null) {
            throw new UserNotFoundException("There is no User with ID = %s in database".formatted(id));
        }
        return userDTO;
    }

    //TODO Determine exception type when trying to save existing login.
    // Want to create dedicated exception type for this
    @PostMapping()
    public UserDTO save(@RequestBody UserDTO userDTO) {
        UserDTO savedUserDTO = userService.save(userDTO);
        return savedUserDTO;
    }

    //TODO Works the same way as "save" method with id within request body.
    // Maybe need to throw exception about non-existent User in Database?
    @PutMapping()
    public UserDTO update(@RequestBody UserDTO userDTO) {
        UserDTO savedUserDTO = userService.save(userDTO);
        return savedUserDTO;
    }

    @DeleteMapping("/{id}")
    public UserDTO delete(@PathVariable Integer id) {
        UserDTO deletedUserDTO = userService.delete(id);
        if (deletedUserDTO == null) {
            throw new UserNotFoundException("There is no User with ID = %s in database".formatted(id));
        }
        return deletedUserDTO;
    }



}
//TODO change controller methods to return UserDTO instead of User: add secret fields for User class which shouldn't be sent
//TODO change controller methods to return ResponseEntity with UserDTO inside

//    @GetMapping()
//    public List<UserDTO> findAll() {
//        List<UserDTO> allUsers = userService.findAll();
//        return allUsers;
//    }