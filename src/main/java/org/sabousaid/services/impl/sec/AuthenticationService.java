package org.sabousaid.services.impl.sec;

import lombok.RequiredArgsConstructor;
import org.sabousaid.Repository.UserRepository;
import org.sabousaid.config.JwtUtils;
import org.sabousaid.dto.AuthenticationRequest;
import org.sabousaid.model.Role;
import org.sabousaid.model.User;
import org.sabousaid.web.sec.AuthenticationResponse;
import org.sabousaid.web.sec.RegisterRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User
                .builder()
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .mail(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        repository.save(user);

        var jwtToken = jwtUtils.generateToken(user);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getEmail(),request.getPassword()
                )
        );

        var user = repository.findByMail(request.getEmail()).orElseThrow();
        var jwtToken = jwtUtils.generateToken(user);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
