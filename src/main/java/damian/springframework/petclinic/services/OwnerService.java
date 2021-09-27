package damian.springframework.petclinic.services;

import damian.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
