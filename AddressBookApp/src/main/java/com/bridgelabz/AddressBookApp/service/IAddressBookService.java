package com.bridgelabz.AddressBookApp.service;


import com.bridgelabz.AddressBookApp.model.Contact;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {
    List<Contact> getAllContacts();
    Optional<Contact> getContactById(Long id);
    Contact addContact(Contact contact);
    Contact updateContact(Long id, Contact contact);
    void deleteContact(Long id);
}
