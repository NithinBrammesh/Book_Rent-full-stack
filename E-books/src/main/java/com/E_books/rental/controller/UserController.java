package com.E_books.rental.controller;

import com.E_books.rental.UserService;
import com.E_books.rental.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
        @RequestMapping
        ResponseEntity<List<UserDto>> getAllUsers(){
            return ResponseEntity.ok(userService.getAllUsers());
        }

        @PostMapping
        ResponseEntity<UserDto> AddUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
      }

      @GetMapping("/{userId}")
       public ResponseEntity<UserDto> getUserId(@PathVariable("userId") int userId){
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
      }
      @PutMapping("/{userId}")
       public ResponseEntity<UserDto> updateUser(@PathVariable int userId, @RequestBody UserDto userDto){
        UserDto updatedUser = userService.updateUser(userId, userDto);
        return ResponseEntity.ok(updatedUser);
      }

      @DeleteMapping("/{userId}")
      public ResponseEntity<UserDto> deleteUserById(@PathVariable("userId") int userId){
      UserDto deleteUserById = userService.getUserById(userId);
       return ResponseEntity.ok(deleteUserById);
    }
}
