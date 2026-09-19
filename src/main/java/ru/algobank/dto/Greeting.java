package ru.algobank.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

import java.time.Instant;

public record Greeting(String bankName, String message, Instant timestamp) {
}
