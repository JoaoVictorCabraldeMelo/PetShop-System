package com.API.Petshop.Address.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.API.Petshop.Address.Model.Address;
import com.API.Petshop.Client.Model.Client;

public interface AddressRepository extends JpaRepository<Address, Integer>  {
    List<Address> findByLogradouro(String logradouro);
    
    Optional<Address> findByClient(Client client);

    List<Address> findByCidade(String cidade);

    List<Address> findByBairro(String bairro);

    List<Address> findByComplemento(String complemento);

    List<Address> findByTag(String tag);

    List<Address> findAll();
}
