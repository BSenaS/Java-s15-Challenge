package com.workintech.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    //Yeni kitap ekle
    public void new_book(Book book){
        this.books.add(book);
    }

    public void deleteBook(Long book_ID){
        for (Book book : this.books){
            if(book.getBook_ID() == book_ID){
                this.books.remove(book);
                System.out.println("Kitap Başarıyla Silindi: " + book);
                return;
            }
        }
        System.out.println("Belirtilen ID'ye sahip kitap bulunamadı");
    }

    public Book findBookById(long bookID) {
        for (Book book : this.books) {
            if (book.getBook_ID() == bookID) {
                return book;
            }
        }
        return null;
    }

    public void findBookByCategory(CATEGORIES category){
        boolean found = false;
        for (Book book : this.books){
            if(book.getCategories() == category){
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Belirtilen kategoriye sahip kitap bulunamadı");
        }
    }


}
