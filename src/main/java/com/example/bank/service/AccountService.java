package com.example.bank.service;

import com.example.bank.model.AccountDTO;

import java.util.List;

public interface AccountService {

    List<AccountDTO> findAll();

    AccountDTO findById(Integer id);

//TODO    List<AccountDTO> findAllByMoney (Integer money);

    AccountDTO save(AccountDTO accountDTO);

    AccountDTO delete(Integer id);
}
