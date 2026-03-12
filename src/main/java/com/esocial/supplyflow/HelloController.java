package com.esocial.supplyflow;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Bonjour ! Votre application Spring Boot fonctionne.";
    }
}


