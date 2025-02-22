package com.E_books.rental;

import com.E_books.rental.dto.UserDto;
import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserById(int userId);
    UserDto updateUser(int userId, UserDto userDto);
    UserDto deleteUser(int userId);
}
