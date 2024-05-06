package wisecode.med.api.domain.patient;

import jakarta.validation.constraints.NotNull;
import wisecode.med.api.domain.address.AddressData;

public record PatientUpdateData(
        @NotNull
        Long id,
        String name,
        String telephone,
        AddressData address
) {
  
}
