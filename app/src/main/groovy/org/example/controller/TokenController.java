package org.example.controller;

import org.example.entities.RefreshToken;
import org.example.entities.UserInfo;
import org.example.entities.UserRole;
import org.example.repository.UserRepository;
import org.example.request.AuthRequestDTO;
import org.example.request.RefreshTokenRequestDTO;
import org.example.response.JWTResponseDTO;
import org.example.service.JWTService;
import org.example.service.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class TokenController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTService jwtService;

    @PostMapping("auth/v1/login")
    public ResponseEntity<JWTResponseDTO> AuthenticateAndGetToken(
            @RequestBody AuthRequestDTO authRequestDTO) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                authRequestDTO.getUsername(),
                                authRequestDTO.getPassword()
                        )
                );

        if (authentication.isAuthenticated()) {

            UserInfo userInfo =
                    userRepository.findByUsername(
                            authRequestDTO.getUsername()
                    );

            if (userInfo == null) {
                return new ResponseEntity<>(
                        HttpStatus.NOT_FOUND
                );
            }

            RefreshToken refreshToken =
                    refreshTokenService.createRefreshToken(
                            authRequestDTO.getUsername()
                    );

            Set<String> roles = userInfo.getRoles()
                    .stream()
                    .map(UserRole::getName)
                    .collect(Collectors.toSet());

            JWTResponseDTO response =
                    JWTResponseDTO.builder()
                            .accessToken(
                                    jwtService.GenerateToken(
                                            authRequestDTO.getUsername()
                                    )
                            )
                            .token(refreshToken.getToken())
                            .userId(userInfo.getUserId())
                            .username(userInfo.getUsername())
                            .roles(roles)
                            .build();

            return new ResponseEntity<>(
                    response,
                    HttpStatus.OK
            );
        }

        return new ResponseEntity<>(
                HttpStatus.UNAUTHORIZED
        );
    }


    @PostMapping("auth/v1/refreshToken")
    public JWTResponseDTO refreshToken(@RequestBody RefreshTokenRequestDTO refreshTokenRequestDTO) {
        return refreshTokenService.findByToken(refreshTokenRequestDTO.getToken())
                .map(refreshTokenService::verifyExpiry)
                .map(RefreshToken::getUserInfo)
                .map(userInfo -> {
                    String accessToken = jwtService.GenerateToken(userInfo.getUsername());
                    return JWTResponseDTO.builder().accessToken(accessToken)
                            .token(refreshTokenRequestDTO.getToken()).build();
                }).orElseThrow(() -> new RuntimeException("Refresh Token is not in DB"));
    }
}
