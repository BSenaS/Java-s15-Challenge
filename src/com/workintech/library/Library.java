package com.workintech.library;

import com.workintech.person.Author;
import com.workintech.person.Member_Record;
import jdk.management.jfr.FlightRecorderMXBean;

import java.time.LocalDate;
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
            System.out.println("---Görev 10 Fatura Kesimi---");
            borrowBookReceipt(member,book);
        }
    }


    public Map<Long, Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void returnBook(Member_Record member, long bookID) {
        if (borrowedBooks.containsKey(member.getMember_id())) {
            Book returnedBook = borrowedBooks.get(member.getMember_id());
            if (returnedBook.getBook_ID() == bookID) {
                returnedBook.setStatus(false);
                borrowedBooks.remove(member.getMember_id());
                member.setMaxBookLimit(member.getMaxBookLimit() - 1);
                System.out.println("Kitap başarıyla iade edildi: " + returnedBook);
            } else {
                System.out.println("Belirtilen ID'ye sahip kitap bu kullanıcı tarafından ödünç alınmamış.");
            }
        } else {
            System.out.println("Bu kullanıcıya ait ödünç alınmış kitap bulunmamaktadır.");
        }
    }

    public void borrowBookReceipt(Member_Record member, Book book){
        System.out.println(book.getName() +": " + "Adlı kitabı ödünç aldınız faturası ektedir.");
        System.out.println("Kitabın fiyatı:" + book.getPrice());
        System.out.println("Kitabı yazarı:" + book.getAuthor());
        System.out.println("Kitabı aldığınız tarih:" + LocalDate.now());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library library)) return false;
        return Objects.equals(books, library.books) && Objects.equals(authors, library.authors) && Objects.equals(members, library.members) && Objects.equals(borrowedBooks, library.borrowedBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books, authors, members, borrowedBooks);
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
