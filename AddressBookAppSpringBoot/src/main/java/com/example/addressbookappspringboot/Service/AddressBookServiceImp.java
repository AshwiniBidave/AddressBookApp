package com.example.addressbookappspringboot.Service;

import com.example.addressbookappspringboot.DTO.ContactDTO;
import com.example.addressbookappspringboot.Entity.Contact;

import java.util.List;

public interface AddressBookServiceImp {
    List<Contact> getContact();
    Contact getContactById(int personId);
    Contact addContact(ContactDTO contactDTO);
    void deleteContactById(int personId);
    Contact updateContactList(int personId,ContactDTO contactDTO);
}
