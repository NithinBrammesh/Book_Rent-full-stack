package com.E_books.rental.serviceImpl;

import com.E_books.rental.UserService;
import com.E_books.rental.dto.UserDto;
import com.E_books.rental.mapper.UserMapper;
import com.E_books.rental.model.User;
import com.E_books.rental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(int userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user doesnt exist"));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto updateUser(int userId, UserDto userDto) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User oes not exist"));
        if(userDto.getName()!=null){
            existingUser.setName(userDto.getName());
        }
        User updatedUser = userRepository.save(existingUser);
        return new UserDto(updatedUser.getUserId(), updatedUser.getName(), updatedUser.getPhoneNo(), updatedUser.getPassword(), updatedUser.getEmail());
    }

    @Override
    public UserDto deleteUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User doesnt exist"));
        UserDto userDto = UserMapper.mapToUserDto(user);
        userRepository.deleteById(userId);
        return userDto;

    }


}