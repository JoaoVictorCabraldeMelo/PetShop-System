package com.API.Petshop.User.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.Petshop.Client.Service.ClientRequest;
import com.API.Petshop.Client.Service.ClientResponse;


@RestController
@RequestMapping("/api/v1/users")
public class UserControllerV1 {
   
    @PutMapping("/client/edit")
    public ResponseEntity<ClientResponse> editMyClient(@RequestBody ClientRequest clientRequest) {
        

        return null;
    }

    @DeleteMapping("/client/delete")
    public void deleteClient() {

    }

    @GetMapping("/client/create")
    public void createClient() {}
}
