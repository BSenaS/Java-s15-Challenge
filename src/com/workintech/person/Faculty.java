package com.workintech.person;

public class Faculty extends Member_Record{
    private MEMBER_TYPE memberType;

    public Faculty(String name, long member_id, Adress adress, Integer maxBookLimit,MEMBER_TYPE memberType) {
        super(name, member_id, adress, maxBookLimit);
        this.memberType = memberType;

    }

    public MEMBER_TYPE getMemberType() {
        return memberType;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + getName() + '\'' +
                ", member_id=" + getMember_id() +
                ", memberType=" + getMemberType() +
                ", address=" + getAdress() +
                ", book_limit=" + getMaxBookLimit() +
                '}';
    }


}
