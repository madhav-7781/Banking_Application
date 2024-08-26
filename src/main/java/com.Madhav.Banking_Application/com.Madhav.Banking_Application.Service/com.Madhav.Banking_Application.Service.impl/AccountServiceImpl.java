package com.Madhav.Banking_Application.Service.impl;

import com.Madhav.Banking_Application.Entity.Account;
import com.Madhav.Banking_Application.Mapping.AccountMapping;
import com.Madhav.Banking_Application.Repository.AccountRepository;
import com.Madhav.Banking_Application.Service.AccountService;
import com.Madhav.Banking_Application.dto.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = AccountMapping.mapToAccount(accountDTO);
        Account savedAccount = accountRepository.save(account);
        return AccountMapping.mapToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO getAccountByID(Long accNumber) {
        Account account = accountRepository.findById(accNumber).orElseThrow(
                () -> new RuntimeException("Account does not exist"));
        return AccountMapping.mapToAccountDTO(account);
    }

    @Override
    public AccountDTO deposit(Long accNumber, double amount) {
        Account account = accountRepository.findById(accNumber).orElseThrow(
                () -> new RuntimeException("Account does not exist"));

        double total = account.getAccBalance() + amount;
        account.setAccBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapping.mapToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO withdraw(Long accNumber, double amount) {
        Account account = accountRepository.findById(accNumber).orElseThrow(
                () -> new RuntimeException("Account does not exist"));

        if (account.getAccBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }

        double total = account.getAccBalance() - amount;
        account.setAccBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapping.mapToAccountDTO(savedAccount);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) ->
                        AccountMapping.mapToAccountDTO(account))
                .collect(Collectors.toList());
        }

    @Override
    public void deleteAccount(Long accNumber) {
        Account account = accountRepository.findById(accNumber).orElseThrow(
                () -> new RuntimeException("Account does not exist"));

        accountRepository.deleteById(accNumber);
    }


}
