package com.example.hoteladri;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainFile {
    @GetMapping("/")
    public HelloResponse sayHello() {
        return new HelloResponse("Bienvenido a Spring, este es un mensaje de que todo está bien");
    }
}