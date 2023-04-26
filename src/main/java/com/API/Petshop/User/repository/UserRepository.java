package com.API.Petshop.User.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.Petshop.User.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByCpf(String cpf);
    List<User> findByName(String name);
}
