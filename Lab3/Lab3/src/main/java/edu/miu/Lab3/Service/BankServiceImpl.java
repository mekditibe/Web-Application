package edu.miu.Lab3.Service;

import edu.miu.Lab3.Entity.Bank;
import edu.miu.Lab3.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BankServiceImpl implements BankService{

    @Autowired
    private BankRepository bankRepository;

    public BankServiceImpl(){
        bankRepository.bankData.put(103563, new Bank(103563, "Mekdes", 2000.90, LocalDate.now()));
        bankRepository.bankData.put(106974, new Bank(106974, "Teffera", 860.90, LocalDate.now()));
        bankRepository.bankData.put(102408, new Bank(102408, "Tebebu", 7520.90, LocalDate.now()));
    }

    @Override
    public void createAccount(Integer accountNumber, String accountHolder) {
        bankRepository.bankData.put(accountNumber,new Bank(accountNumber,accountHolder));
    }

    @Override
    public void deposit(Integer accountNumber, Double amount) {
        Bank bank= this.getAccount(accountNumber);
        bank.setBalance(amount);
        bankRepository.bankData.put(accountNumber,bank);
    }

    @Override
    public void withdraw(Integer accountNumber, Double amount) {
        Bank bank= this.getAccount(accountNumber);
        bank.setBalance(bank.getBalance() - amount);
        bankRepository.bankData.put(accountNumber,bank);
    }

    @Override
    public void removeAccount(Integer accountNumber) {
        bankRepository.bankData.remove(accountNumber);
    }

    @Override
    public Bank getAccount(Integer accountNumber) {
        return bankRepository.bankData.get(accountNumber);
    }
}
