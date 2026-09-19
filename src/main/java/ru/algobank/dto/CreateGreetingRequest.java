package ru.algobank.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateGreetingRequest(@NotBlank String name) {
}
