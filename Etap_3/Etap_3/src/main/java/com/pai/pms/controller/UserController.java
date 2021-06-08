package com.pai.pms.controller;

import com.pai.pms.model.entities.User;
import com.pai.pms.model.repository.UserRepository;
import com.pai.pms.payload.response.JwtResponse;
import com.pai.pms.payload.response.UserMeResponse;
import com.pai.pms.security.exception.ResourceNotFoundException;
import com.pai.pms.security.services.CurrentUser;
import com.pai.pms.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    public ResponseEntity<UserMeResponse> getCurrentUser(@CurrentUser UserDetailsImpl userPrincipal) {
        User user = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));

        List<String> roles = userPrincipal.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new UserMeResponse(user.getId(), user.getLogin(), user.getEmail(), roles));
    }
}
