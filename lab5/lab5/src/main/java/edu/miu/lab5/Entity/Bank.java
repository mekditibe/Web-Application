package edu.miu.lab5.Entity;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class Bank {

    @Id
    private Integer id;
    private Integer accountNumber;
    private String accountHolder;
    private Double balance;
    private LocalDate date;

    public Bank(){}
    public Bank(Integer id,Integer accountNumber, String accountHolder){
        this.id=id;
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
    }
    public Bank(Integer id,Integer accountNumber, String accountHolder, Double balance, LocalDate date){
        this.id=id;
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
        this.date=date;
    }


}
