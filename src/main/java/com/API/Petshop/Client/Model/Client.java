package com.API.Petshop.Client.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.API.Petshop.Address.Model.Address;
import com.API.Petshop.Contact.Model.Contact;
import com.API.Petshop.Pet.Model.Pet;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Entity
@EqualsAndHashCode(exclude = {"address", "contact", "pets"})
@Table(name="Clients")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, optional = true)
    private Address address;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, optional = true)
    private Contact contact;

    @ManyToMany(mappedBy = "clients", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Pet> pets = new HashSet<>();
    
    @Column
    private String name;
   
    @Column
    private Date registerDate;

    public void addPet(Pet pet) {
        pets.add(pet);
        pet.getClients().add(this);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
        pet.getClients().remove(this);
    }
}
