package wisecode.med.api.domain.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wisecode.med.api.domain.address.Address;
import wisecode.med.api.domain.doctor.Specialty;


@Table(name = "patient")
@Entity(name = "Patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String email;
    private String telephone;
    @Embedded
    private Address address;
    private boolean active;

    public Patient(PatientRegistrationData data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.telephone = data.telephone();
        this.address = new Address(data.address());
    }

    public void updateInformation(PatientUpdateData data) {
        if(data.name() != null){
            this.name = data.name();

        }
        if(data.telephone() != null){
            this.telephone = data.telephone();
        }
        if(data.address() != null ) {
            this.address.updateInformation(data.address());
        }




    }

    public void delete() {
        this.active = false;
    }
}
