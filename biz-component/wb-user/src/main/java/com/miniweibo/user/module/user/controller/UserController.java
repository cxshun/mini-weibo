package com.miniweibo.user.module.user.controller;

import com.miniweibo.user.module.user.controller.dto.LoginReq;
import com.miniweibo.user.module.user.controller.dto.LoginResp;
import com.miniweibo.user.module.user.service.impl.JwtService;
import com.miniweibo.user.module.user.service.impl.JwtUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nicolas.chan
 * 2020/9/6
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private JwtUserDetailServiceImpl jwtUserDetailService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * user auth with loginId and password
     * @param loginReq login entity
     * @return  token
     */
    @PostMapping("auth")
    public LoginResp auth(@RequestBody @Validated LoginReq loginReq) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getLoginId(), loginReq.getPassword()));
        UserDetails userDetails = jwtUserDetailService.loadUserByUsername(loginReq.getLoginId());
        String token = jwtService.generateToken(userDetails);
        return new LoginResp(token);
    }

}
