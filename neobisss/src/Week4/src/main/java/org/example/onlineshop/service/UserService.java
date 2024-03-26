package org.example.onlineshop.service;

import lombok.AllArgsConstructor;
import org.example.onlineshop.config.JwtUtil;
import org.example.onlineshop.authen.AuthenticationResponse;
import org.example.onlineshop.authen.LoginRequest;
import org.example.onlineshop.authen.RegisterRequest;
import org.example.onlineshop.entity.Role;
import org.example.onlineshop.entity.User;
import org.example.onlineshop.exception.UserNotFoundException;
import org.example.onlineshop.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request){
        var user = User.builder()
                .name(request.getFirstname())
                .surname(request.getLastname())
                .password(encoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtUtil.generateToken(user.getEmail());
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
    public AuthenticationResponse login(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        String userEmail = user.getEmail();
        var jwtToken = jwtUtil.generateToken(userEmail);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
