package edu.miu.Lab3.Controller;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class BookTest {
    @Test
    public void whenRequestGet_thenOK(){
        when().request("GET", "/books").then().statusCode(200);
    }

    @Test
    public void whenAddBook_thenOK(){
        when().request("Post", "/books").then().assertThat().body("banks.isbn", equalTo("isbn4")).statusCode(200);
    }
    @Test
    public void whenGet_thenOK(){
        given().relaxedHTTPSValidation("TLSv1.2")
                .when().get("isbn1")
                .then().assertThat().body("book.isbn", equalTo("isbn1"))
                .body("book.author", equalTo("Mekdes"))
                .body("book.title", equalTo("for life"))
                .body("book.price", equalTo(22.7))
                .statusCode(200);
    }
}
//        bookRepository.bookData.put("isbn1", new Book("isbn1", "Mekdes", "for life", 22.7));