package com.workintech.person;

public class Member_Record extends Person{
    private long member_id;
    private int maxBookLimit;
    private Adress adress;

    public Member_Record(String name,long member_id,Adress adress,Integer maxBookLimit) {
        super(name);
        this.member_id = member_id;
        this.adress = adress;
        this.maxBookLimit = maxBookLimit;
    }

    @Override
    public void whoYouAre() {
    }

    public long getMember_id() {
        return member_id;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setMember_id(long member_id) {
        this.member_id = member_id;
    }

    public void setMaxBookLimit(int maxBookLimit) {
        this.maxBookLimit = maxBookLimit;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Member_Record{" +
                "member_id=" + member_id +
                ", maxBookLimit=" + maxBookLimit +
                ", adress=" + adress +
                '}';
    }
}
