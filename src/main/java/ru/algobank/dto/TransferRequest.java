package ru.algobank.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TransferRequest(@NotNull Long fromId,@NotNull Long toId, @Positive long amount) {
}
