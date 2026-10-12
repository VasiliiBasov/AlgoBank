package ru.algobank.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.algobank.dto.TransferRequest;
import ru.algobank.service.TransferService;

@RestController
@Tag(name = "Transfer", description = "Controller for debit and credit")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/api/transfer")
    public void transfer(@Valid @RequestBody TransferRequest transferRequest) {
        transferService.transfer(transferRequest.fromId(),  transferRequest.toId(), transferRequest.amount());
    }

}
