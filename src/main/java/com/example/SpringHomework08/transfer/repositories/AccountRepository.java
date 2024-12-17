package com.example.SpringHomework08.transfer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.SpringHomework08.transfer.model.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
