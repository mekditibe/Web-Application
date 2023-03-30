package edu.miu.Lab7.Repositiry;

import edu.miu.Lab7.Entity.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends MongoRepository<Bank, Integer> {
    Bank findBankByAccountNumber(Integer accountNumber);
    List<Bank> findAll();
    Bank findBankByAccountHolder(String accountHolder);
}
