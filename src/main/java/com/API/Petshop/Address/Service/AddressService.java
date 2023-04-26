package com.API.Petshop.Address.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.API.Petshop.Address.Model.Address;
import com.API.Petshop.Address.Repository.AddressRepository;
import com.API.Petshop.Client.Model.Client;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;

    public AddressResponse returnAddressOfClient(Client client) throws NotFoundException {
        Optional<Address> address = addressRepository.findByClient(client);

        if (!address.isPresent()) throw new NotFoundException();

        var addr = address.get();

        return AddressResponse.builder()
                                .bairro(addr.getBairro())
                                .logradouro(addr.getLogradouro())
                                .cidade(addr.getCidade())
                                .complemento(addr.getComplemento())
                                .tag(addr.getTag())
                                .build();     
    }

    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }

    public AddressResponse editAddress(Address address) {
        addressRepository.save(address);
        return AddressResponse.builder()
                                .bairro(address.getBairro())
                                .logradouro(address.getLogradouro())
                                .cidade(address.getCidade())
                                .complemento(address.getComplemento())
                                .tag(address.getTag())
                                .build();
    }

    public List<AddressResponse> returnAllAdresses() {
        List<Address> addressResponses = addressRepository.findAll();
        return addressResponses.stream().map(address -> AddressResponse.builder()
                                                            .bairro(address.getBairro())
                                                            .cidade(address.getCidade())
                                                            .complemento(address.getComplemento())
                                                            .logradouro(address.getComplemento())
                                                            .tag(address.getTag())
                                                            .build()).collect(Collectors.toList());
    }


}
