package com.bridgelabz.AddressBookApp.model;




import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String phoneNumber;

    public Contact(AddressBookDTO addressBookDTO) {
        this.name = addressBookDTO.getName();
        this.address = addressBookDTO.getAddress();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
    }

    public void setId(Long id) {
        
    }


    public void setName(String name) {
    }

    public void setAddress(String address) {
    }

    public void setPhoneNumber(String phoneNumber) {
    }
}