package damian.springframework.petclinic.services;


import damian.springframework.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findAll(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
