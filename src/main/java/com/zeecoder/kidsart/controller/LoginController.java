package com.zeecoder.kidsart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping
public class LoginController {

    @GetMapping("/")
    public String getDefaultPage() {
        return "default";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "Hello login";
    }

    @GetMapping("/restricted")
    public String getRestrictedPage() {
        return "Hello restricted";
    }
}
