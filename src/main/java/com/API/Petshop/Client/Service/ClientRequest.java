package com.API.Petshop.Client.Service;

import java.util.Date;

import com.API.Petshop.Address.Service.AddressRequest;
import com.API.Petshop.Contact.Service.ContactRequest;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

    @Nullable
    private AddressRequest address;

    @Nullable
    private ContactRequest contact;

    @Nullable
    private String name;

    @Nullable
    private Date registerDate;
}
