package edu.miu.Lab3.Controller;

import edu.miu.Lab3.Entity.Bank;
import edu.miu.Lab3.Service.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banks")
public class BankController {
    @Autowired
    private BankServiceImpl bankService;


    @GetMapping("/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable Integer accountNumber) {
        return new ResponseEntity<Bank>(this.bankService.getAccount(accountNumber), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createAccount(@RequestParam Integer accountNumber, @RequestParam String accountHolder) {
        this.bankService.createAccount(accountNumber, accountHolder);
        return new ResponseEntity<String>("Bank account is created successful ", HttpStatus.OK);
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<?> removeAccount(@PathVariable Integer accountNumber) {
        this.bankService.removeAccount(accountNumber);
        return new ResponseEntity<String>("Bank account is deleted successful ", HttpStatus.OK);
    }

    @PatchMapping("/deposit/{accountNumber}")
    public ResponseEntity<?> deposit(@PathVariable Integer accountNumber, @RequestParam Double amount) {
        this.bankService.deposit(accountNumber,amount);
        return new ResponseEntity<String>("Deposit is successful", HttpStatus.OK);
    }

    @PatchMapping("/withdraw/{accountNumber}")
    public ResponseEntity<?> withdraw(@PathVariable Integer accountNumber, @RequestParam Double amount) {
        this.bankService.withdraw(accountNumber,amount);
        return new ResponseEntity<String>("Withdraw is successful", HttpStatus.OK);
    }

}
