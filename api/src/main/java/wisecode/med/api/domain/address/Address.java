package wisecode.med.api.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String neighborhood;
    private String zip_code;
    private String city;
    private String state;
    private String number;
    private String complement;

    public Address(AddressData data) {
        this.street = data.street();
        this.city = data.city();
        this.state = data.state();
        this.number = data.number();
        this.complement = data.complement();
        this.neighborhood = data.neighborhood();
        this.zip_code = data.zip_code();
    }

    public void updateInformation(AddressData data) {
      if(data.street() != null){
          this.street = data.street();
      }
      if(data.city() != null){
            this.city = data.city();
      }
      if(data.state() != null){
            this.state = data.state();
      }
      if(data.number() != null){
            this.number = data.number();
      }
      if(data.complement() != null){
            this.complement = data.complement();
      }
      if(data.neighborhood() != null){
            this.neighborhood = data.neighborhood();
      }
      if(data.zip_code() != null){
            this.zip_code = data.zip_code();
      }

    }
}
