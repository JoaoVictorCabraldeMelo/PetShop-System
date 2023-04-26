package com.API.Petshop.Client.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.API.Petshop.Address.Service.AddressResponse;
import com.API.Petshop.Client.Model.Client;
import com.API.Petshop.Client.Repository.ClientRepository;
import com.API.Petshop.Contact.Service.ContactResponse;

@Service
public class ClientService {
   
    @Autowired
    private ClientRepository clientRepository;

    public ClientResponse editClient(Integer id) throws NotFoundException {
        Optional<Client> client = clientRepository.findClientById(id);

        if (!client.isPresent()) throw new NotFoundException();

        var c = client.get();
        var address = c.getAddress();
        var contact = c.getContact();

        return ClientResponse.builder()
                            .address(AddressResponse.builder()
                                    .build())
                            .contact(ContactResponse.builder()
                                    .build())
                            .name(c.getName())
                            .regisDate(c.getRegisterDate())     
                            .build();    
    }

}
