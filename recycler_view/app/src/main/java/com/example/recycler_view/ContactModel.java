package com.example.recycler_view;

public class ContactModel {
    int img;
    String name;
    String number;

    public ContactModel(int img, String name, String number){
        this.name = name;
        this.number = number;
        this.img = img;

    }

    public ContactModel(String name , String number){
        this.name = name;
        this.number = number;
    }


}
