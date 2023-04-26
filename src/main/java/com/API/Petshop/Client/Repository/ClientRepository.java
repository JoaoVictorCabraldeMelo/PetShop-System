package com.API.Petshop.Client.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.Petshop.Client.Model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findClientById(Integer id);
}
