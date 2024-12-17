package com.example.SpringHomework08.transfer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.SpringHomework08.transfer.dto.TransferRequest;
import com.example.SpringHomework08.transfer.services.TransferService;

@RestController
@AllArgsConstructor
public class TransferController {

    private final TransferService transferService;


    @PutMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }
}
