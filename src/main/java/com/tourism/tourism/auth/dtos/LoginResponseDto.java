package com.tourism.tourism.auth.dtos;

import com.tourism.tourism.person.enums.PersonType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponseDto {
    private String token;
    private String name;
    private PersonType personType;
    private String photo;
}
