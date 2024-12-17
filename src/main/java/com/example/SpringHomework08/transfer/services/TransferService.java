package com.example.SpringHomework08.transfer.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.SpringHomework08.transfer.aspect.TrackAction;
import com.example.SpringHomework08.transfer.model.Account;
import com.example.SpringHomework08.transfer.repositories.AccountRepository;

@Service
@AllArgsConstructor
public class TransferService {

    private final AccountRepository accountRepository;

    @TrackAction
    @Transactional
    public void transferMoney(long idSender, long idReceiver, Double amount) {
        Account sender = accountRepository.findById(idSender).orElseThrow(null);
        Account receiver = accountRepository.findById(idReceiver).orElseThrow(null);
        Double senderNewAmount = sender.getAmount() - amount;
        Double receiverNewAmount = receiver.getAmount() + amount;
        if (senderNewAmount >= 0) {
            changeAmount(idSender, senderNewAmount);
            changeAmount(idReceiver, receiverNewAmount);
        } else {
            throw new RuntimeException("Недостаточно средств на счету!");
        }
    }


    private void changeAmount(long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(null);
        account.setAmount(amount);

    }
}
