package com.API.Petshop.User.model;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.API.Petshop.Client.Model.Client;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Users")
public class User implements UserDetails {
  
  @Id  
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(unique = true, nullable = false)
  private String cpf;

  @Column(nullable = false)
  private String password;

  @Column
  @ElementCollection(fetch = FetchType.EAGER)
  @Enumerated(EnumType.STRING)
  @Singular
  private Set<Role> roles;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "client_id")
  private Client client;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
  }

  @Override
  public String getUsername() {
    return cpf;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public static UserBuilder builder() {
    return new UserBuilder().roles(new HashSet<>());
  }
}