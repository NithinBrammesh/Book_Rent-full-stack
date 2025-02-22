package com.E_books.rental.mapper;

import com.E_books.rental.dto.UserDto;
import com.E_books.rental.model.User;

public class UserMapper {

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getUserId(),  // Fix: userId should be the first parameter
                userDto.getPhoneNo(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }

    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getUserId(),  // Fix: userId should be first
                user.getName(),
                user.getPhoneNo(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
