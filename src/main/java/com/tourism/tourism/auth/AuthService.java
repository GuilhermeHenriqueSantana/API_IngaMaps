package com.tourism.tourism.auth;

import com.tourism.tourism.auth.dtos.LoginResponseDto;
import com.tourism.tourism.person.Person;
import com.tourism.tourism.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Objects;

@Service
public class AuthService {
    @Autowired
    PersonService personService;

    public String generateToken(String username, String password) {
        return "Basic " + new String(Base64.getEncoder().encode((username + ":" + password).getBytes()));
    }

    public LoginResponseDto buildLoginResponseDTO(String username, String password) {
        Person person = personService.getPersonByUsername(username);
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setToken(generateToken(username, password));
        loginResponseDto.setName(person.getName());
        loginResponseDto.setPersonType(person.getPersonType());
        loginResponseDto.setPhoto(Objects.isNull(person.getPhoto()) ? null : person.getPhoto().getBase64());
        return loginResponseDto;
    }
}
