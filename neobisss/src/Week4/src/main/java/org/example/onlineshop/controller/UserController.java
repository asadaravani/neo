package org.example.onlineshop.controller;

import org.example.onlineshop.authen.AuthenticationResponse;
import org.example.onlineshop.authen.LoginRequest;
import org.example.onlineshop.authen.RegisterRequest;
import org.example.onlineshop.exception.UserAlreadyExistsException;
import org.example.onlineshop.exception.UserNotFoundException;
import org.example.onlineshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * Register a User.
     *
     * @return Optional<Product>
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        try {
            userService.register(request);
        }catch (UserAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    /**
     * Login.
     *
     * @return Optional<Product>
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        AuthenticationResponse authenticationResponse;
        try {
            authenticationResponse = userService.login(request);
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok(authenticationResponse);
    }


}
