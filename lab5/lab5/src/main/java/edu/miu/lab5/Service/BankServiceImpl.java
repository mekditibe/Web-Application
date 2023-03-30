package edu.miu.lab5.Service;

import edu.miu.lab5.Entity.Bank;
import edu.miu.lab5.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class BankServiceImpl implements BankService{

    @Autowired
    private BankRepository bankRepository;

    public void add5Bank() {
        bankRepository.save(new Bank(1,103563, "Mekdes", 2000.90, LocalDate.now()));
        bankRepository.save(new Bank(2,106974, "Teffera", 860.90, LocalDate.now()));
        bankRepository.save(new Bank(3,102408, "Tebebu", 7520.90, LocalDate.now()));
    }

    @Override
    public void createAccount(Integer id, Integer accountNumber, String accountHolder) {
        bankRepository.save(new Bank(id,accountNumber,accountHolder));
    }

    @Override
    public void deposit(Integer accountNumber, Double amount) {
        Bank bankAccount= bankRepository.findBankByAccountNumber(accountNumber);
        bankAccount.setBalance(amount);
        bankRepository.save(bankAccount);
    }

    @Override
    public void withdraw(Integer accountNumber, Double amount) {
        Bank bankAccount= bankRepository.findBankByAccountNumber(accountNumber);
        bankAccount.setBalance(bankAccount.getBalance()-amount);
        bankRepository.save(bankAccount);
    }

    @Override
    public void addBank(Bank bank) {
        bankRepository.save(bank);
    }

    @Override
    public Bank findBankById(Integer accountNumber) {
        return bankRepository.findBankByAccountNumber(accountNumber);
    }



}
