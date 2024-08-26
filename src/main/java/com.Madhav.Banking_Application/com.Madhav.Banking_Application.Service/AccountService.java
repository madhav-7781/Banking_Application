//Interface
package com.Madhav.Banking_Application.Service;

import com.Madhav.Banking_Application.dto.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO);
    AccountDTO getAccountByID(Long accNumber);
    AccountDTO deposit(Long accNumber, double amount);
    AccountDTO withdraw(Long accNumber, double amount);
    List<AccountDTO> getAllAccounts();
    void deleteAccount(Long accNumber);

}
