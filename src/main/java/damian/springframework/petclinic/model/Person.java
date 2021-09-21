package damian.springframework.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person  extends BaseEntity{
    public Person(Long id, String fistName, String lastName) {
        super(id);
        this.fistName = fistName;
        LastName = lastName;
    }

    @Column(name = "first_name")
    private String fistName;

    @Column(name = "last_name")
    private String LastName;
}
