package com.example.productservice.commons;

import com.example.productservice.dtos.UserDto;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationCommons {
    private RestTemplate restTemplate;

    public AuthenticationCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String token) {
        ResponseEntity<UserDto> response = restTemplate.postForEntity("http://localhost:8080/users/validate/"+token, null, UserDto.class);
        return response.getBody();
    }

}
