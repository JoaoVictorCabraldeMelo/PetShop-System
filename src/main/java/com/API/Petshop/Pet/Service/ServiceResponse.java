package com.API.Petshop.Pet.Service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse {
    
    private double price;

    private String description;

    private Date regisDate;
}
