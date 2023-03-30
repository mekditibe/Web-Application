package edu.miu.lab5.Controller;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
public class StudentTest {

    @Test
    public void whenRequestGet_thenOK(){
        when().request("GET", "/students").then().statusCode(200);
    }
    @Test
    public void whenWithdraw_thenOK(){
        when().request("Patch", "/students/phoneNumber").then().assertThat().body("students.phoneNumber", equalTo(3545435)).statusCode(200);
    }
    @Test
    public void whenDeposit_thenOK(){
        when().request("Patch", "/students/city").then().assertThat().body("students.city", equalTo("city")).statusCode(200);
    }
    @Test
    public void whenGet_thenOK(){
        given().relaxedHTTPSValidation("TLSv1.2")
                .when().get("1")
                .then().assertThat().body("students.phoneNumber", equalTo(10312563))
                .body("students.name", equalTo("Mekdes"))
                .body("students.city", equalTo("city"))
                .statusCode(200);
    }


}
