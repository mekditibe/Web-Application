package edu.miu.lab2.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Cart {

    private int quantity;
    private Product product;
    private double total;




    public Cart(Product product, int quantity, double total) {
        this.product = product;
        this.quantity = quantity;
        this.total=total;
    }




}
