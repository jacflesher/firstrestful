package com.myfirstrestfulservice.myFirstRestfulService.Controllers;

import com.myfirstrestfulservice.myFirstRestfulService.Methods.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class AddressBookResource {

    ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/contacts/{id}")
    public Contact getContact(@PathVariable String id){
        return contacts.get(id);
    }
    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return new ArrayList<Contact>(contacts.values());
    }
    @PostMapping("/addcontact")
    public Contact addContact(@RequestBody Contact contact){
        contacts.put(contact.getId(), contact);
        return contact;
    }
}
