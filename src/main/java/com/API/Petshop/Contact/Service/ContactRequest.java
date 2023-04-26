package com.API.Petshop.Contact.Service;

import com.API.Petshop.Contact.Model.ContactType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {
    
    private String tag;

    private ContactType type;
}
