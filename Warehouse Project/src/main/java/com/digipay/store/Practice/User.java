package com.digipay.store.Practice;

public class User {
    @Creator("Ebrahim")
    @Creator("Sahar")
    @Creator("Hamid")
    @Creator
    public String firstName;

    public String showMessage(){
        String name;
        String message = "Hi";
        return message;


    }
}
