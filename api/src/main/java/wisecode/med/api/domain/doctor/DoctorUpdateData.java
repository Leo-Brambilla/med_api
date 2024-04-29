package wisecode.med.api.domain.doctor;

import jakarta.validation.constraints.NotNull;

import wisecode.med.api.domain.address.AddressData;

public record DoctorUpdateData(
        @NotNull
        Long id,
        String name,
        String telephone,
        AddressData address
) {
  
}
