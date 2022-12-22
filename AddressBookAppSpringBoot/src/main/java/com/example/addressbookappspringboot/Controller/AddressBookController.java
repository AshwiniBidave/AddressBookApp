package com.example.addressbookappspringboot.Controller;

import com.example.addressbookappspringboot.DTO.ContactDTO;
import com.example.addressbookappspringboot.DTO.ResponseDTO;
import com.example.addressbookappspringboot.Entity.Contact;
import com.example.addressbookappspringboot.Service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AddressBook")
public class AddressBookController {
    @Autowired
    AddressBookService addressBookService;
    @RequestMapping("/get")
    public ResponseEntity<ResponseDTO> getAllContact(){
        List<Contact> contactList=addressBookService.getContact();
        ResponseDTO responseDTO=new ResponseDTO("Get call Success",contactList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable int personId){
        Contact contactListById=addressBookService.getContactById(personId);
        ResponseDTO responseDTO=new ResponseDTO("Get call Success By Id",contactListById);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> CreateEmployeePayroll(@Valid @RequestBody ContactDTO contactDTO){
        Contact Data=addressBookService.addContact(contactDTO);
        ResponseDTO responseDTO=new ResponseDTO("Create AddressBok Data Successfully",Data);
        return  new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
    }
    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> UpdateEmployeePayroll(@PathVariable("personId") int personId, @RequestBody ContactDTO contactDTO){
        Contact Data=addressBookService.updateContactList(personId,contactDTO);
        ResponseDTO responseDTO=new ResponseDTO("Update Employee Payroll Data Successfully",Data);
        return  new ResponseEntity<>(responseDTO,HttpStatus.OK);

    }
    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> DeleteEmployeePayroll(@PathVariable int personId){
        addressBookService.deleteContactById(personId);
        ResponseDTO responseDTO=new ResponseDTO("Deleted successfully",+personId);
        return  new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }


}
