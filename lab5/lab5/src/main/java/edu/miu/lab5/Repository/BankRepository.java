package edu.miu.lab5.Repository;

import edu.miu.lab5.Entity.Bank;
import edu.miu.lab5.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BankRepository extends MongoRepository<Bank, Integer> {

    Bank findBankByAccountNumber(Integer accountNumber);
    List<Bank> findAll();
    Bank findBankByAccountHolder(String accountHolder);


}
