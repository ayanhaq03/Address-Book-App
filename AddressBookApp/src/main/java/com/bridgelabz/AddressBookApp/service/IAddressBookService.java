package com.bridgelabz.AddressBookApp.service;


import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.model.Contact;

import java.util.List;
import java.util.Optional;

 public interface IAddressBookService {
    List<Contact> getAllContacts();
    Optional<Contact> getContactById(Long id);
    Contact addContact(AddressBookDTO contactDTO);
    Contact updateContact(Long id, AddressBookDTO contactDTO);
    void deleteContact(Long id);
}