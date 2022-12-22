package com.example.addressbookappspringboot.Entity;

import com.example.addressbookappspringboot.DTO.ContactDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int personId;

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

public Contact(ContactDTO contactDTO){
    this.firstName=contactDTO.getFirstName();
    this.lastName = contactDTO.getLastName();
    this.address = contactDTO.getAddress();
    this.city = contactDTO.getCity();
    this.state = contactDTO.getState();
    this.zip = contactDTO.getZip();
    this.phone = contactDTO.getPhone();
    this.email = contactDTO.getEmail();

}

}
