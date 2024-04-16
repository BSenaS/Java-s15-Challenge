package com.workintech.person;

public class Reader extends Person{
    public Reader(String name) {
        super(name);
    }

    @Override
    public void whoYouAre() {
        System.out.println(getName() + " is a Reader");
    }
}
