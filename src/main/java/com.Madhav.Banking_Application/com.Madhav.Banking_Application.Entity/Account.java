package com.Madhav.Banking_Application.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Account_Number")
    private Long accNumber;

    @Column(name="Account_Holder_Name")
    private String accHolderName;

    @Column(name="Account_Balance")
    private double accBalance;
}
