package edu.miu.Lab7.Entity;
import java.time.LocalDate;

public class Bank {

    private Integer accountNumber;
    private String accountHolder;
    private Double balance;
    private LocalDate date;

    public Bank(){}
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
