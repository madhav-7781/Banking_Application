package com.Madhav.Banking_Application.Mapping;

import com.Madhav.Banking_Application.Entity.Account;
import com.Madhav.Banking_Application.dto.AccountDTO;

public class AccountMapping {
    public static Account mapToAccount(AccountDTO accountDTO) {
        Account account = new Account(
                accountDTO.getAccNumber(),
                accountDTO.getAccHolderName(),
                accountDTO.getAccBalance()
        );

        return account;
    }

    public static AccountDTO mapToAccountDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO(
                account.getAccNumber(),
                account.getAccHolderName(),
                account.getAccBalance()
        );

        return accountDTO;
    }
}
