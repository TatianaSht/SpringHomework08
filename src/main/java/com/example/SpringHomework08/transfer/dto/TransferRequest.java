package com.example.SpringHomework08.transfer.dto;

import lombok.Data;


@Data
public class TransferRequest {

    private long senderAccountId;
    private long receiverAccountId;
    private Double amount;

}
