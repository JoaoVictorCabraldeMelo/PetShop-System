package com.API.Petshop.Pet.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.Petshop.Pet.Model.Pet;
import com.API.Petshop.Pet.Model.Race;
import com.API.Petshop.Pet.Model.Service;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    List<Pet> findByName(String name);
    List<Pet> findByRace(Race race);
    List<Pet> findByService(Service service);
    List<Pet> findByBirthday(Date date);

}
