package com.API.Petshop.Address.Model;


import com.API.Petshop.Client.Model.Client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"client"} )
@Entity
@Table(name="Adressess")
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
   
    @Column
    private String logradouro;

    @Column
    private String cidade;

    @Column
    private String bairro;

    @Column
    private String complemento;

    @Column
    private String tag;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

}
