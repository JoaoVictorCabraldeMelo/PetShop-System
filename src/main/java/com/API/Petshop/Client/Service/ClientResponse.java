package com.API.Petshop.Client.Service;

import java.util.Date;

import com.API.Petshop.Address.Service.AddressResponse;
import com.API.Petshop.Contact.Service.ContactResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
    
    private AddressResponse address;

    private String name;

    private Date regisDate;

    private ContactResponse contact;
}
