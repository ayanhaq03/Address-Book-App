package com.bridgelabz.AddressBookApp.controller;


import com.bridgelabz.AddressBookApp.model.Contact;
import com.bridgelabz.AddressBookApp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    // Get all contacts
    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(addressBookService.getAllContacts());
    }

    // Get contact by ID
    @GetMapping("/contacts/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Optional<Contact> contact = addressBookService.getContactById(id);
        return contact.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new contact
    @PostMapping("/contacts")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
        return ResponseEntity.ok(addressBookService.addContact(contact));
    }

    // Update contact by ID
    @PutMapping("/contacts/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        Contact updatedContact = addressBookService.updateContact(id, contact);
        return updatedContact != null ? ResponseEntity.ok(updatedContact) : ResponseEntity.notFound().build();
    }

    // Delete contact by ID
    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        addressBookService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}