package com.bridgelabz.AddressBookApp.service;


import com.bridgelabz.AddressBookApp.model.Contact;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Override
    public List<Contact> getAllContacts() {
        return Arrays.asList(

        );
    }
}
