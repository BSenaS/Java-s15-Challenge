package com.workintech.person;

import com.workintech.library.Book;

import java.util.List;

public class Librarian extends Person{
    public Librarian(String name) {
        super(name);
    }

    @Override
    public List<Book> getBooks() {
        return super.getBooks();
    }

    @Override
    public void whoYouAre() {
        System.out.println(getName() + " is a Librarian");
    }



    public Book searchBook(Long book_ID){
        List<Book> kitaplar = getBooks();
        for(Book book : kitaplar){
            if(book.getBook_ID() == book_ID){
                return book;
            }
        }
        return null;
    }

}
