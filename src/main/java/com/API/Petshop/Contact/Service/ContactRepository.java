package com.API.Petshop.Contact.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.API.Petshop.Client.Model.Client;
import com.API.Petshop.Contact.Model.Contact;
import com.API.Petshop.Contact.Model.ContactType;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    Optional<Contact> findByClient(Client client);

    List<Contact> findByTag(String tag);

    List<Contact> findByType(ContactType type); 
}
