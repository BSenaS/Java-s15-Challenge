package com.workintech.person;

public class Adress {
    private String country;
    private String city;
    private String homeNumber;
    private String phoneNo;

    public Adress(String country, String city, String homeNumber, String phoneNo) {
        this.country = country;
        this.city = city;
        this.homeNumber = homeNumber;
        this.phoneNo = phoneNo;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", homeNumber='" + homeNumber + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
