package com.bridgelabz.AddressBookApp.model;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
}
