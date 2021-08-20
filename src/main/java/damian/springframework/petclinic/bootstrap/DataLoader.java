package damian.springframework.petclinic.bootstrap;

import damian.springframework.petclinic.model.*;
import damian.springframework.petclinic.services.OwnerService;
import damian.springframework.petclinic.services.PetTypeService;
import damian.springframework.petclinic.services.SpecialityService;
import damian.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialitiesService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("German Shepherd");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType snake = new PetType();
        dog.setName("pyton");
        PetType savedSnakePetType = petTypeService.save(snake);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFistName("Krystian");
        owner1.setLastName("Kaminski");
        owner1.setAddress("245 Urzejowice");
        owner1.setCity("Przeworsk");
        owner1.setTelephone("555 312 091");

        Pet krystiansPet = new Pet();
        krystiansPet.setPetType(savedDogPetType);
        krystiansPet.setOwner(owner1);
        krystiansPet.setBirthDate(LocalDate.now());
        krystiansPet.setName("Tino");
        owner1.getPets().add(krystiansPet);
        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFistName("Frank");
        owner2.setLastName("Cunningham");
        owner2.setAddress("45 mikulice");
        owner2.setCity("Kańczuga");
        owner2.setTelephone("555 213 780");
        Pet franksPet = new Pet();
        franksPet.setPetType(savedSnakePetType);
        franksPet.setOwner(owner2);
        franksPet.setBirthDate(LocalDate.now());
        franksPet.setName("Durant");
        owner2.getPets().add(franksPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners");

        Vet vet1 = new Vet();
        vet1.setFistName("ELINOR");
        vet1.setLastName("MCGRATH");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFistName("Claude");
        vet2.setLastName("Bourgelat");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("loaded vets");
    }
}
