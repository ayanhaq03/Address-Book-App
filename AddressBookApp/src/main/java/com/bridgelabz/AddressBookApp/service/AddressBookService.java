package com.bridgelabz.AddressBookApp.service;
import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;


import com.bridgelabz.AddressBookApp.model.Contact;
import com.bridgelabz.AddressBookApp.repository.AddressBookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;
@Data
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
    public Contact addContact(AddressBookDTO contactDTO) {
        Contact contact = new Contact(contactDTO);  // Model creation in Service Layer
        return addressBookRepository.save(contact);
    }

    @Override
    public Contact updateContact(Long id, AddressBookDTO contactDTO) {
        Optional<Contact> existingContact = addressBookRepository.findById(id);
        if (existingContact.isPresent()) {
            Contact contact = existingContact.get();
            contact.setName(contactDTO.getName());
            contact.setAddress(contactDTO.getAddress());

            contact.setPhoneNumber(contactDTO.getPhoneNumber());
            return addressBookRepository.save(contact);
        }
        return null;
    }

    @Override
    public void deleteContact(Long id) {
        addressBookRepository.deleteById(id);
    }
}