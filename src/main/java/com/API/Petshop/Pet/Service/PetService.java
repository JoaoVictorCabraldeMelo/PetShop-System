package com.API.Petshop.Pet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.Petshop.Client.Model.Client;
import com.API.Petshop.Pet.Repository.PetRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetService {
    
    @Autowired
    private PetRepository petRepository;
    
}
