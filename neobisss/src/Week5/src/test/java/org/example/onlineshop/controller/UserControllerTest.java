package org.example.onlineshop.controller;

import org.example.onlineshop.authen.LoginRequest;
import org.example.onlineshop.authen.RegisterRequest;
import org.example.onlineshop.exception.UserAlreadyExistsException;
import org.example.onlineshop.exception.UserNotFoundException;
import org.example.onlineshop.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

class UserControllerTest {
    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void register_Success() {
        RegisterRequest registerRequest = new RegisterRequest("test", "testov",
                "testov.test@gmail.com","password");

        ResponseEntity<?> responseEntity = userController.register(registerRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
    @Test
    void register_UserAlreadyExists() {
        RegisterRequest registerRequest = new RegisterRequest("Jembo", "Brtan",
                "brtan.jembo@gmail.com","password");
        doThrow(new UserAlreadyExistsException("User already exists")).when(userService).register(registerRequest);

        ResponseEntity<?> responseEntity = userController.register(registerRequest);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
    @Test
    void login_Success() {
        LoginRequest loginRequest = new LoginRequest("brtan.jembo@gmail.com", "password");


        ResponseEntity<?> responseEntity = userController.login(loginRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
    @Test
    void login_userNotFoundException() {
        LoginRequest loginRequest = new LoginRequest("beganov.asad@gmail.com", "password");

        doThrow(new UserNotFoundException("User not found")).when(userService).login(loginRequest);

        ResponseEntity<?> responseEntity = userController.login(loginRequest);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

}