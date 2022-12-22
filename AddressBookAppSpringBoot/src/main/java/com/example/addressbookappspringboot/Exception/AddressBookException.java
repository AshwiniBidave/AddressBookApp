package com.example.addressbookappspringboot.Exception;

public class AddressBookException extends RuntimeException{
    public AddressBookException() {
    }

    public AddressBookException(String message) {
        super(message);
    }
}
