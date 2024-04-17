package com.workintech.person;

public class Student extends Member_Record{
    private MEMBER_TYPE memberType;

    public Student(String name, long member_id, Adress adress, Integer maxBookLimit, MEMBER_TYPE memberType) {
        super(name, member_id, adress, maxBookLimit);
        this.memberType = memberType;

    }


    public MEMBER_TYPE getMemberType() {
        return memberType;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", member_id=" + getMember_id() +
                ", memberType=" + getMemberType() +
                ", address=" + getAdress() +
                ", book_limit=" + getMaxBookLimit() +
                '}';
    }

}
