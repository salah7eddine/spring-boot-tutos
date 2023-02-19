package org.sabousaid.web.sec;

import lombok.RequiredArgsConstructor;
import org.sabousaid.config.JwtUtils;
import org.sabousaid.dao.UserDao;
import org.sabousaid.dto.AuthenticationRequest;
import org.sabousaid.services.impl.sec.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final AuthenticationService service;
    private final JwtUtils jwtUtils;

 /*   @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(request.getEmail());
        if(userDetails != null) {
            return ResponseEntity.ok(jwtUtils.generateToken(userDetails));
        }
        return ResponseEntity.status(400).body("some error has occurred");
    }*/

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(this.service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
       return ResponseEntity.ok(this.service.authenticate(request));
    }
}
