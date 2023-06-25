package com.mx100;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class Mx100ServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(Mx100ServiceApplication.class, args);
	}

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
