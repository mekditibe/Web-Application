package edu.miu.lab2.Entity;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    @NotNull
    @Size(min = 2, max = 5)
    String prNumber;
    @NotNull
    @Size(min = 2, max = 20)
    String name;

    double price;

    public Product(String prNumber, String name, double price) {
        this.prNumber = prNumber;
        this.name = name;
        this.price = price;
    }


}
