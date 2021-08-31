package damian.springframework.petclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person  extends BaseEntity{

    @Column(name = "first_name")
    private String fistName;

    @Column(name = "last_name")
    private String LastName;

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
