package com.API.Petshop.Pet.Service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RaceResponse {
    
    private String race;

    private String description;
}
