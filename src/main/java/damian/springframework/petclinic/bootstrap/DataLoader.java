package damian.springframework.petclinic.bootstrap;

import damian.springframework.petclinic.model.Owner;
import damian.springframework.petclinic.model.Vet;
import damian.springframework.petclinic.services.OwnerService;
import damian.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
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
        vet1.setFistName("as");
        vet1.setLastName("pieski");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFistName("dlugas");
        vet2.setLastName("wezowaty");
        vetService.save(vet2);
        System.out.println("loaded vets");

    }
}
