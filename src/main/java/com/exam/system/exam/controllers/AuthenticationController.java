package com.exam.system.exam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.exam.system.exam.model.JwtRequest;
import com.exam.system.exam.model.JwtResponse;
import com.exam.system.exam.security.JwtUtil;
import com.exam.system.exam.service.impl.UserDetailsServiceImpl;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println("Ha entrado en el end-point");
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (UsernameNotFoundException exception) {
            exception.printStackTrace();
            System.out.println("No se ha encontrado el usuario");
            throw new Exception("Usuario no encontrado");
        }

        UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());

        System.out.println("Se esta imprimiendo el username->" + userDetails.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            System.out.println("El usuario " + username + "la contrase{a} " + password);
        } catch (DisabledException disabledException) {
            disabledException.printStackTrace();
            System.out.println("DisabledException");
        } catch (BadCredentialsException badCredentialsException) {
            badCredentialsException.printStackTrace();
            System.out.println("BadCredentialsException");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
