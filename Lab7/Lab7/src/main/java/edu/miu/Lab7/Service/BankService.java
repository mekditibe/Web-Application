package edu.miu.Lab7.Service;

import edu.miu.Lab7.Entity.Bank;
import edu.miu.Lab7.Repositiry.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public void createAccount(Integer accountNumber, String accountHolder) {
        bankRepository.save(new Bank(accountNumber,accountHolder));
    }

    public void deposit(Integer accountNumber, Double amount) {
        Bank bankAccount= bankRepository.findBankByAccountNumber(accountNumber);
        bankAccount.setBalance(amount);
        bankRepository.save(bankAccount);
    }

    public void withdraw(Integer accountNumber, Double amount) {
        Bank bankAccount= bankRepository.findBankByAccountNumber(accountNumber);
        bankAccount.setBalance(bankAccount.getBalance()-amount);
        bankRepository.save(bankAccount);
    }

    public void addBank(Bank bank) {
        bankRepository.save(bank);
    }

    public Optional<Bank> findBankById(Integer accountNumber) {
        return Optional.of(bankRepository.findBankByAccountNumber(accountNumber));
    }
    public List<Bank> findAllBank() {
        return bankRepository.findAll();
    }


}
