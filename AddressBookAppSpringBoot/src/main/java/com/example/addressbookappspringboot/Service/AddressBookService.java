package com.example.addressbookappspringboot.Service;

import com.example.addressbookappspringboot.DTO.ContactDTO;
import com.example.addressbookappspringboot.Entity.Contact;
import com.example.addressbookappspringboot.Exception.AddressBookException;
import com.example.addressbookappspringboot.Repositoty.AddressBookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;


@Service
public class AddressBookService implements AddressBookServiceImp {
    @Autowired
    AddressBookRepo addressBookRepo;
    @Autowired
    EmailSenderService emailSenderService;

    @Override
    public List<Contact> getContact() {
        if (addressBookRepo.findAll().isEmpty()) {
            throw new AddressBookException(" No Contact is found");
        } else {
            return addressBookRepo.findAll();
        }
    }

    @Override
    public Contact getContactById(int personId) {
        return addressBookRepo.findById(personId).orElseThrow(() -> new AddressBookException("contact with given ID not Found"));

    }

    @Override

    public Contact addContact(ContactDTO contactDTO) {
        Contact contact = new Contact(contactDTO);
        List<String> states = new ArrayList<>();
        states.add("Maharastra");
        states.add("Andhra pradesh");
        states.add("Asam");
        boolean state = states.contains(contact.getState());
        if (state) {
            emailSenderService.SendEmail(contact.getEmail(), "new contact created-" + contact.getFirstName(), contact.toString());
            return addressBookRepo.save(contact);
        } else {
            throw new AddressBookException("Enter valid State");
        }

    }


    @Override
    public void deleteContactById(int personId) {
      addressBookRepo.deleteById(personId);
    }

    @Override
    public Contact updateContactList(int personId, ContactDTO contactDTO) {
        Contact contact=new Contact(contactDTO);
        contact.setPersonId(personId);
        contact.setModifiedDate(LocalDate.now());
        return addressBookRepo.save(contact);

    }
}
