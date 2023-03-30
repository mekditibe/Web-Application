package edu.miu.lab5.Service;

import edu.miu.lab5.Entity.Bank;
import edu.miu.lab5.Entity.Student;

import java.util.List;

public interface BankService {

    void createAccount(Integer id,Integer accountNumber, String accountHolder);
    void deposit(Integer accountNumber, Double amount);
    void withdraw(Integer accountNumber, Double amount);
    void addBank(Bank bank);
    Bank findBankById(Integer accountNumber);



}
