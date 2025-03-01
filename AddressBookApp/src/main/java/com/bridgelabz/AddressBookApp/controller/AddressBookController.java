package com.bridgelabz.AddressBookApp.controller;


import com.bridgelabz.AddressBookApp.model.Contact;
import com.bridgelabz.AddressBookApp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return addressBookService.getAllContacts();
    }
}
