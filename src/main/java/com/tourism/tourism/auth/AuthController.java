package com.tourism.tourism.auth;

import com.tourism.tourism.auth.dtos.ChangePasswordDto;
import com.tourism.tourism.auth.dtos.LoginDto;
import com.tourism.tourism.auth.dtos.LoginResponseDto;
import com.tourism.tourism.userlogin.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/public/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService authService;
    @Autowired
    private UserLoginService userLoginService;

    @PostMapping
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    loginDto.getUsername(), loginDto.getPassword()
                            )
                    );

            return ResponseEntity.ok(authService.buildLoginResponseDTO(loginDto.getUsername(), loginDto.getPassword()));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping(path = "change-password")
    public ResponseEntity<LoginResponseDto> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    changePasswordDto.getUsername(), changePasswordDto.getPassword()
                            )
                    );

            userLoginService.changePassword(changePasswordDto);
            return ResponseEntity.ok(authService.buildLoginResponseDTO(changePasswordDto.getUsername(), changePasswordDto.getNewPassword()));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
