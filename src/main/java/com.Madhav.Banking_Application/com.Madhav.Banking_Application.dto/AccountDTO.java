package com.Madhav.Banking_Application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {
    private Long accNumber;
    private String accHolderName;
    private double accBalance;
}
