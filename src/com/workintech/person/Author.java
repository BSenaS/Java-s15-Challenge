package com.workintech.person;

public class Author extends Person{
    public Author(String name) {
        super(name);
    }

    @Override
    public void whoYouAre() {
        System.out.println(getName() + " is a Author");
    }
}
