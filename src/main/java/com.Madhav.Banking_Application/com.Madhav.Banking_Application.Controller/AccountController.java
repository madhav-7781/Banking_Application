package com.Madhav.Banking_Application.Controller;

import com.Madhav.Banking_Application.Service.AccountService;
import com.Madhav.Banking_Application.dto.AccountDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDTO> accountDTOResponseEntity(@RequestBody AccountDTO accountDTO) {
        return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
    }

    //Get Account REST API
    @GetMapping("/{accNumber}")
    public ResponseEntity<AccountDTO> getAccountByID(@PathVariable Long accNumber) {
        AccountDTO accountDTO = accountService.getAccountByID(accNumber);
        return ResponseEntity.ok(accountDTO);
    }

    //Deposit REST API
    @PutMapping("/{accNumber}/deposit")
    public ResponseEntity<AccountDTO> deposit(@PathVariable Long accNumber, @RequestBody Map<String, Double> request) {
        double amount = request.get("amount");
        AccountDTO accountDTO = accountService.deposit(accNumber, amount);
        return ResponseEntity.ok(accountDTO);
    }

    //Withdraw REST API
    @PutMapping("/{accNumber}/withdraw")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable Long accNumber, @RequestBody Map<String, Double> request) {
        double amount = request.get("amount");
        AccountDTO accountDTO = accountService.withdraw(accNumber,amount);
        return ResponseEntity.ok(accountDTO);
    }

    //Get All Account
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        List<AccountDTO> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    //Delete REST API
    @DeleteMapping("/{accNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accNumber) {
        accountService.deleteAccount(accNumber);
        return ResponseEntity.ok("Account Deleted Successfully!!");
    }
}
