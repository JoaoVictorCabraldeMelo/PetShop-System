package com.API.Petshop;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.API.Petshop.Address.Model.Address;
import com.API.Petshop.Client.Model.Client;
import com.API.Petshop.Contact.Model.Contact;
import com.API.Petshop.Contact.Model.ContactType;
import com.API.Petshop.Pet.Model.Pet;
import com.API.Petshop.Pet.Model.Race;
import com.API.Petshop.Pet.Repository.PetRepository;
import com.API.Petshop.User.model.Role;
import com.API.Petshop.User.model.User;
import com.API.Petshop.User.repository.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@Transactional
@RequiredArgsConstructor
public class DefaultUser implements ApplicationRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EntityManager entityManager;

    @Autowired
    private PetRepository petRepository;

    @Override
    public void run(ApplicationArguments args) {

        var client = Client.builder()
                            .name("Chefinho")
                            .registerDate(new Date())
                            .build();
                            
        var address = Address.builder()
                                .logradouro("Quadra")
                                .bairro("Brasilia")
                                .cidade("Guara")
                                .complemento("Casa")
                                .tag("Just a tag")
                                .client(client)
                                .build();

        client.setAddress(address);

        var contact = Contact.builder()
                                .tag("joao.victor.cabralmelo@gmail.com")
                                .type(ContactType.EMAIL)
                                .client(client)
                                .build();
        
        client.setContact(contact);


        var bruce = Pet.builder()
                        .birthday(new Date())
                        .name("Bruce")
                        .race(Race.builder()
                                    .race("Border Collie")
                                    .description("Loucura")
                                    .build()).build();
        
        var maradona =  Pet.builder()
                            .birthday(new Date())
                            .name("Maradonna")
                            .race(Race.builder()
                                        .race("Vira-lata")
                                        .description("De boas")
                                        .build()).build();
        
        bruce.addClient(client);
        maradona.addClient(client);

        petRepository.save(bruce);
        petRepository.save(maradona);

        entityManager.merge(client);

        var user = User.builder()
                        .cpf("333.333-33")
                        .name("admin")
                        .password(passwordEncoder.encode("admin"))
                        .client(client)
                        .role(Role.ADMIN)
                        .build();

        userRepository.save(user);
    } 
    
}
