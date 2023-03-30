package edu.miu.Lab4.Entity;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import javax.validation.constraints.Size;
import java.time.LocalDate;

public class Bank {

    @NotNull
    @Size(min = 2, max = 5)
    private Integer accountNumber;
    @NotNull
    private String accountHolder;
    private Double balance;
    private LocalDate date;

    public Bank(Integer accountNumber, String accountHolder){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
    }
    public Bank(Integer accountNumber, String accountHolder, Double balance, LocalDate date){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
        this.date=date;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

}
