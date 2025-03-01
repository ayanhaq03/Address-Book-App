package com.bridgelabz.AddressBookApp.service;
import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;


import com.bridgelabz.AddressBookApp.model.Contact;
import com.bridgelabz.AddressBookApp.repository.AddressBookRepository;
import org.springframework.stereotype.Service;
import java.util.*;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Data

@Service
public class AddressBookService implements IAddressBookService {

    private final List<Contact> contactList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1); // Simulates auto-incremented IDs

    @Override
    public List<Contact> getAllContacts() {
        return contactList;
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return contactList.stream()
                .filter(contact -> contact.getId().equals(id))
                .findFirst();
    }

    @Override
    public Contact addContact(AddressBookDTO contactDTO) {
        Contact contact = new Contact(contactDTO);
        contact.setId(idCounter.getAndIncrement()); // Assigns a unique ID
        contactList.add(contact);
        return contact;
    }

    @Override
    public Contact updateContact(Long id, AddressBookDTO contactDTO) {
        Optional<Contact> existingContact = getContactById(id);
        if (existingContact.isPresent()) {
            Contact contact = existingContact.get();
            contact.setName(contactDTO.getName());
            contact.setAddress(contactDTO.getAddress());
            contact.setPhoneNumber(contactDTO.getPhoneNumber());
            return contact;
        }
        return null; // Returns null if contact not found
    }

    @Override
    public void deleteContact(Long id) {
        contactList.removeIf(contact -> contact.getId().equals(id));
    }
}