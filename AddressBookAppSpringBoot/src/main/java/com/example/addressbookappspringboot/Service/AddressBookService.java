package com.example.addressbookappspringboot.Service;

import com.example.addressbookappspringboot.DTO.ContactDTO;
import com.example.addressbookappspringboot.Entity.Contact;
import com.example.addressbookappspringboot.Exception.AddressBookException;
import com.example.addressbookappspringboot.Repositoty.AddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookService implements AddressBookServiceImp {
    @Autowired
    AddressBookRepo addressBookRepo;
    @Override
    public List<Contact> getContact() {
        if(addressBookRepo.findAll().isEmpty()){
        throw  new AddressBookException(" No Contact is found");
        }
        else {
            return addressBookRepo.findAll();
        }
    }

    @Override
    public Contact getContactById(int personId) {
        return addressBookRepo.findById(personId).orElseThrow(()-> new AddressBookException("Employee with given ID not Found"));

    }

    @Override
    public Contact addContact(ContactDTO contactDTO) {
        Contact contact=new Contact(contactDTO);
        return addressBookRepo.save(contact);
    }

    @Override
    public void deleteContactById(int personId) {
      addressBookRepo.deleteById(personId);
    }

    @Override
    public Contact updateContactList(int personId, ContactDTO contactDTO) {
        Contact contact=new Contact(contactDTO);
        contact.setPersonId(personId);
        return addressBookRepo.save(contact);

    }
}
