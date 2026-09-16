package ru.algobank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.algobank.dto.Greeting;

import java.time.Instant;

@RestController
public class HelloBankController {

    @GetMapping("/api/hello")
    public Greeting greeting(){
        return new Greeting("AlgoBank",
                "Добро пожаловать в AlgoBank API", Instant.now());
    }

}
