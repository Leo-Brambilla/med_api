package wisecode.med.api.doctor;

import jakarta.validation.constraints.NotNull;

import wisecode.med.api.address.AddressData;

public record DoctorUpdateData(
        @NotNull
        Long id,
        String name,
        String telephone,
        AddressData address
) {
  
}
