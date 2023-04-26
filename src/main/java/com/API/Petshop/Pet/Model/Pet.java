package com.API.Petshop.Pet.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.API.Petshop.Client.Model.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@EqualsAndHashCode(exclude = {"clients"})
@Table(name = "Pets")
public class Pet {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "pet_client", 
    joinColumns = @JoinColumn(name = "pet_id"), 
    inverseJoinColumns = @JoinColumn(name="client_id"))
    @Builder.Default
    private Set<Client> clients = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "race_id")
    private Race race;

    @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
    private Service service;

    @Column
    private Date birthday;

    @Column
    private String name;

    public void addClient(Client client) {
        clients.add(client);
        client.getPets().add(this);
    }

    public void removeClient(Client client) {
        clients.remove(client);
        client.getPets().remove(this);
    }
}
