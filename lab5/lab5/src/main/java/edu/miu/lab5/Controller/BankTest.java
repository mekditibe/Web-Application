package edu.miu.lab5.Controller;


import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class BankTest {


    @Test
    public void whenRequestGet_thenOK(){
        when().request("GET", "/banks").then().statusCode(200);
    }
    @Test
    public void whenWithdraw_thenOK(){
        when().request("Patch", "/banks/withdraw").then().assertThat().body("banks.amount", equalTo(12.2)).statusCode(200);
    }
    @Test
    public void whenDeposit_thenOK(){
        when().request("Patch", "/banks/deposit").then().assertThat().body("banks.amount", equalTo(12.2)).statusCode(200);
    }
    @Test
    public void whenGet_thenOK(){
        given().relaxedHTTPSValidation("TLSv1.2")
                .when().get("103563")
                .then().assertThat().body("bank.accountNumber", equalTo(103563))
                .body("bank.accountHolder", equalTo("Mekdes"))
                .body("bank.balance", equalTo(2000.90))
                .statusCode(200);
    }
}


//        bankRepository.bankData.put(103563, new Bank(103563, "Mekdes", 2000.90, LocalDate.now()));