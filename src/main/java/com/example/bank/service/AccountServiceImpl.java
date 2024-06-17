package com.example.bank.service;

import com.example.bank.entity.User;
import com.example.bank.model.UserDTO;
import com.example.bank.repository.AccountRepository;
import com.example.bank.repository.UserRepository;
import com.example.bank.entity.Account;
import com.example.bank.model.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDTO> findAll() {
        List<Account> allAccounts = accountRepository.findAll();
        List<AccountDTO> allAccountsDTO = new ArrayList<>();
        allAccounts.forEach(user -> allAccountsDTO.add(toAccountDTO(user)));
        return allAccountsDTO;
    }

    @Override
    public AccountDTO findById(Integer id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (!optionalAccount.isPresent()) {
            return null;
        }
        AccountDTO accountDTO = toAccountDTO(optionalAccount.get());
        return accountDTO;
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        Account savedAccount = accountRepository.save(toAccount(accountDTO));
        AccountDTO savedAccountDTO = toAccountDTO(savedAccount);
        return savedAccountDTO;
    }


    @Override
    public AccountDTO delete(Integer id) {
        AccountDTO deletedAccountDTO = findById(id);
        accountRepository.deleteById(id);
        return deletedAccountDTO;
    }

    private AccountDTO toAccountDTO(Account account) {

        return new AccountDTO(account.getId(), account.getMoneyAmount(), account.getUser_id());
    }
    private Account toAccount(AccountDTO accountDTO) {
        return new Account(accountDTO.getId(), accountDTO.getMoneyAmount(), accountDTO.getUser_id());
    }
}
