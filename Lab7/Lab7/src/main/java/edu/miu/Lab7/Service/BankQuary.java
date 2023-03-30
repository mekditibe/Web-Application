package edu.miu.Lab7.Service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import edu.miu.Lab7.Entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BankQuary implements GraphQLQueryResolver {

    @Autowired
    private BankService bankService;

    public List<Bank> getBanks() {
        return bankService.findAllBank();
    }
    public Optional<Bank> getBankByID(final Integer customerNumber) {
        return bankService.findBankById(customerNumber);
    }
}
