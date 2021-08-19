package damian.springframework.petclinic.bootstrap;

import damian.springframework.petclinic.model.Owner;
import damian.springframework.petclinic.model.PetType;
import damian.springframework.petclinic.model.Vet;
import damian.springframework.petclinic.services.OwnerService;
import damian.springframework.petclinic.services.PetTypeService;
import damian.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("As");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType snake = new PetType();
        dog.setName("Długas");
        PetType savedSnakePetType = petTypeService.save(snake);


        Owner owner1 = new Owner();
        owner1.setFistName("Krystian");
        owner1.setLastName("Kaminski");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFistName("Frank");
        owner2.setLastName("Cunningham");

        ownerService.save(owner2);

        System.out.println("Loaded owners");

        Vet vet1 = new Vet();
        vet1.setFistName("ELINOR");
        vet1.setLastName("MCGRATH");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFistName("Claude");
        vet2.setLastName("Bourgelat");
        vetService.save(vet2);
        System.out.println("loaded vets");

    }
}
