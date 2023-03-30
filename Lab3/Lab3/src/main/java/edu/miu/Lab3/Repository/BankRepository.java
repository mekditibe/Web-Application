package edu.miu.Lab3.Repository;

import edu.miu.Lab3.Entity.Bank;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public interface BankRepository {

    Map<Integer, Bank> bankData = new HashMap<>();

}
