package ru.algobank.dto;

import java.time.Instant;

public record Greeting(String bankName, String message, Instant timestamp) {
}
