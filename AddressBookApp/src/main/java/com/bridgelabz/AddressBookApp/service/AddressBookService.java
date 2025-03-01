package com.bridgelabz.AddressBookApp.service;
import org.springframework.beans.factory.annotation.Autowired;


import com.bridgelabz.AddressBookApp.model.Contact;
import com.bridgelabz.AddressBookApp.repository.AddressBookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<Contact> getAllContacts() {
        return addressBookRepository.findAll();
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return addressBookRepository.findById(id);
    }

    @Override
    public Contact addContact(Contact contact) {
        return addressBookRepository.save(contact);
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {
        if (addressBookRepository.existsById(id)) {
            contact.setId(id);
            return addressBookRepository.save(contact);
        }
        return null;
    }

    @Override
    public void deleteContact(Long id) {
        addressBookRepository.deleteById(id);
    }
}
