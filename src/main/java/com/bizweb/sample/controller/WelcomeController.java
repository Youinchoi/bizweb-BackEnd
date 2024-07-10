package com.bizweb.sample.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:18082")
public class WelcomeController {
	@GetMapping("/api/welcome")
    public String welcome() {
        return "환영합니다!";
    }
}
