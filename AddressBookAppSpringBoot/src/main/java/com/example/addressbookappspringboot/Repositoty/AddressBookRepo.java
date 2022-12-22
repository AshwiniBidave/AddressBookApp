package com.example.addressbookappspringboot.Repositoty;

import com.example.addressbookappspringboot.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepo extends JpaRepository<Contact,Integer> {
}
