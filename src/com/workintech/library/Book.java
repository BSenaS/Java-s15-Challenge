package com.workintech.library;

public class Book {
    private long book_ID;
    private String author;
    private String name;
    private double price;
    private boolean status;

    private CATEGORIES categories;

    public Book(long book_ID, String author, String name, double price, boolean status, CATEGORIES categories) {
        this.book_ID = book_ID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.categories = categories;
    }

    public long getBook_ID() {
        return book_ID;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public CATEGORIES getCategories() {
        return categories;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setBook_ID(long book_ID) {
        this.book_ID = book_ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCategories(CATEGORIES categories) {
        this.categories = categories;
    }

    //change_owner
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_ID=" + book_ID +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", categories=" + categories +
                '}';
    }
}
