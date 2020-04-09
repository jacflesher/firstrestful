package com.myfirstrestfulservice.myFirstRestfulService.AddressBook;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class AddressBook {

    ConcurrentMap<String, ContactProperties> contacts = new ConcurrentHashMap<>();

    @GetMapping("/contacts/{id}")
    public ContactProperties getContact(@PathVariable String id){
        return contacts.get(id);
    }
    @GetMapping("/contacts")
    public List<ContactProperties> getAllContacts() {
        return new ArrayList<ContactProperties>(contacts.values());
    }
    @PostMapping("/addcontact")
    public ContactProperties addContact(@RequestBody ContactProperties contactProperties){
        contacts.put(contactProperties.getId(), contactProperties);
        return contactProperties;
    }
}
