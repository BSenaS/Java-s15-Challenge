package com.workintech.library;

import com.workintech.person.Author;
import com.workintech.person.Member_Record;

import java.util.*;

public class Library {
    private List<Book> books;
    private Set<Author> authors;
    private Map<Integer,String> members;

    private Map<Long,Book> borrowedBooks;


    public Library() {
        this.books = new ArrayList<>();
        this.authors = new HashSet<>();
        this.borrowedBooks = new HashMap<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    //Yeni kitap ekle
    public void new_book(Book book){
        this.books.add(book);
    }
    public void new_author(Author author){
        this.authors.add(author);
    }

    public Set<Author> getAuthors(){
        return authors;
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

    public void findByAuthor(String authorName){
        boolean found = false;
        for (Book book : this.books)
            if (book.getAuthor().equals(authorName)) {
                System.out.println(book);
                found = true;
            }
        if (!found) {
            System.out.println("Belirtilen kategoriye sahip kitap bulunamadı");
        }
    }

    public void borrowBook(Member_Record member, Book book){
        if(book.isStatus()){
            System.out.println("Kitap zaten başkası tarafından alınmış.");
        }else if(member.getMaxBookLimit() == 5) {
            System.out.println("Maxium kitap alma limitinize ulaştınız...");

        }else {
            book.setStatus(true);
            borrowedBooks.put(member.getMember_id(),book);
            member.setMaxBookLimit(member.getMaxBookLimit() + 1);
            System.out.println(book.getName() + " " + "Adlı Kitap başarıyla ödünç alındı.");
        }
    }


    public Map<Long, Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library library)) return false;
        return Objects.equals(books, library.books) && Objects.equals(authors, library.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books, authors);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", authors=" + authors +
                ", members=" + members +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
