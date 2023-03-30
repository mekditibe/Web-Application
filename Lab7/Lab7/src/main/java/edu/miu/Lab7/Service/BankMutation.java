package edu.miu.Lab7.Service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class BankMutation implements GraphQLQueryResolver {

    @Autowired
    private BankService bankService;

    public void createBankAccount(final Integer accountNumber, final String accountHolder) {
        bankService.createAccount(accountNumber, accountHolder);
    }
}
