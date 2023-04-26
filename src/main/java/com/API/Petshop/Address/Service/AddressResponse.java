package com.API.Petshop.Address.Service;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    
    private String logradouro;

    private String cidade;

    private String bairro;

    private String complemento;

    private String tag;
}
