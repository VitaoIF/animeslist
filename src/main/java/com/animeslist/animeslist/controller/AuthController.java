package com.animeslist.animeslist.controller;

import com.animeslist.animeslist.config.TokenComponent;
import com.animeslist.animeslist.dto.request.LoginRequest;
import com.animeslist.animeslist.dto.request.UserRequest;
import com.animeslist.animeslist.dto.response.LoginResponse;
import com.animeslist.animeslist.dto.response.UserResponse;
import com.animeslist.animeslist.entity.User;
import com.animeslist.animeslist.exceptions.UsernameOrPasswordInvalidException;
import com.animeslist.animeslist.mapper.UserMapper;
import com.animeslist.animeslist.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenComponent tokenComponent;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request){
        User registeredUser = userService.register(UserMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(registeredUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        try {
            UsernamePasswordAuthenticationToken userAuthorization = new UsernamePasswordAuthenticationToken(request.email(), request.password());
            Authentication authenticate = authenticationManager.authenticate(userAuthorization);

            User user = (User) authenticate.getPrincipal();

            String token = tokenComponent.generateToken(user);

            return ResponseEntity.ok(new LoginResponse(token));

        } catch (BadCredentialsException e){
            throw new  UsernameOrPasswordInvalidException("Email ou Senha incorretos");
        }
    }
}
