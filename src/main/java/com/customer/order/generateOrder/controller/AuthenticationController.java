package com.customer.order.generateOrder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.order.generateOrder.request.AuthRequest;
import com.customer.order.generateOrder.util.jwtTokenUtil;

@RestController
public class AuthenticationController {

	@Autowired
    private jwtTokenUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    
	@RequestMapping({ "/hello" })
	public String firstPage() {
	return "Hello World";
	}
	
	@PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
