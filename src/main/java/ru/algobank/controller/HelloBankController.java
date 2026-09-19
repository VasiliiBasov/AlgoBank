package ru.algobank.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.algobank.algo.step05.BankGreeter;
import ru.algobank.dto.CreateGreetingRequest;
import ru.algobank.dto.Greeting;

import java.time.Instant;

@RestController
public class HelloBankController {
    private final BankGreeter greeter;

    public HelloBankController(BankGreeter greeter) {
        this.greeter = greeter;
    }

    @GetMapping("/api/hello")
    public Greeting greeting() {
        return new Greeting("AlgoBank",
                "Добро пожаловать в AlgoBank API", Instant.now());
    }

    @PostMapping("/api/greet")
    public Greeting greeting(@Valid @RequestBody CreateGreetingRequest req) {
        return new Greeting("AlgoBank", greeter.greet(req.name()), Instant.now());
    }

}
