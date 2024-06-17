package com.example.bank.controller;

import com.example.bank.exception.AccountNotFoundException;
import com.example.bank.model.AccountDTO;
import com.example.bank.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public List<AccountDTO> findAll() {
        List<AccountDTO> allUsers = accountService.findAll();
        return allUsers;
    }

    @GetMapping("/{id}")
    public AccountDTO findById(@PathVariable Integer id) {
        AccountDTO AccountDTO = accountService.findById(id);
        if (AccountDTO == null) {
            throw new AccountNotFoundException("There is no Account with ID = %s in database".formatted(id));
        }
        return AccountDTO;
    }
    @PostMapping()
    public AccountDTO save(@RequestBody AccountDTO AccountDTO) {
        AccountDTO savedAccountDTO = accountService.save(AccountDTO);
        return savedAccountDTO;
    }

    //TODO works the same way as "save" method with id within request body
    @PutMapping()
    public AccountDTO update(@RequestBody AccountDTO AccountDTO) {
        AccountDTO savedAccountDTO = accountService.save(AccountDTO);
        return savedAccountDTO;
    }

    @DeleteMapping("/{id}")
    public AccountDTO delete(@PathVariable Integer id) {
        AccountDTO deletedAccountDTO = accountService.delete(id);
        if (deletedAccountDTO == null) {
            throw new AccountNotFoundException("There is no Account with ID = %s in database".formatted(id));
        }
        return deletedAccountDTO;
    }
}
