package edu.miu.Lab3.Entity;


import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import javax.validation.constraints.Size;

public class Book {
    @NotNull
    @Size(min = 2, max = 5)
    private String isbn;
    @NotNull
    private String author;
    private String title;
    private Double price;

    public Book(String isbn, String author, String title, Double price){
        this.isbn=isbn;
        this.author=author;
        this.title=title;
        this.price=price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
