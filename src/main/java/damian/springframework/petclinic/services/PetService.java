package damian.springframework.petclinic.services;

import damian.springframework.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findAll(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();

}
