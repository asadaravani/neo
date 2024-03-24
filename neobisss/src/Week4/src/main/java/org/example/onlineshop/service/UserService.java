package org.example.onlineshop.service;

import lombok.AllArgsConstructor;
import org.example.onlineshop.dto.UserDTO;
import org.example.onlineshop.entity.User;
import org.example.onlineshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserDTO registration( UserDTO userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        userDto.setId(user.getId());
        userRepository.save(user);
        return userDto;
    }
    public UserDTO login(UserDTO userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        userDto.setId(user.getId());
        userRepository.save(user);
        return userDto;
    }
}
