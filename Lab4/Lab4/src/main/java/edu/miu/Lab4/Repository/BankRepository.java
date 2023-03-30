package edu.miu.Lab4.Repository;

import edu.miu.Lab4.Entity.Bank;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public interface BankRepository {

    Map<Integer, Bank> bankData = new HashMap<>();

}
