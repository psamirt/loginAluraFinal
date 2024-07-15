package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.security.AuthCredentials;
import com.aluracursos.forohub.security.TokenUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody AuthCredentials authCredentials){
        String token = TokenUtils.createToken(authCredentials.getEmail(), authCredentials.getEmail());

        Map<String, String> response = new HashMap<>();
        response.put("token", "Bearer " + token);
        return ResponseEntity.ok(response);
    }
}
