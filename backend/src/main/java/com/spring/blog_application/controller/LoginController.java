package com.spring.blog_application.controller;

import com.spring.blog_application.utils.AuthRequest;
import com.spring.blog_application.utils.AuthResponse;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.util.stream.Collectors;

//@RestController
public class LoginController {
    private final NimbusJwtEncoder nimbusJwtEncoder;
    private final AuthenticationManager authenticationManager;

    public LoginController(NimbusJwtEncoder nimbusJwtEncoder, AuthenticationManager authenticationManager) {
        this.nimbusJwtEncoder = nimbusJwtEncoder;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/api/login")
    public AuthResponse authenticate(@Valid @RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );
        return new AuthResponse(createToken(authentication));
    }

    private String createToken(Authentication authentication) {
        var claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(60 * 60 * 60))
                .subject(authentication.getName())
                .claim("scope", createScope(authentication))
                .build();

        return nimbusJwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    private String createScope(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
    }
}
