package edu.miu.Lab3.Service;

import edu.miu.Lab3.Entity.Bank;

public interface BankService {

    void createAccount(Integer accountNumber, String accountHolder);
    void deposit(Integer accountNumber, Double amount);
    void withdraw(Integer accountNumber, Double amount);
    void removeAccount(Integer accountNumber);
    Bank getAccount(Integer accountNumber);

}
