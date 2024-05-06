package wisecode.med.api.domain.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import wisecode.med.api.domain.address.AddressData;
import wisecode.med.api.domain.doctor.Specialty;

public record PatientRegistrationData(

        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telephone,
        @NotNull
        @Valid
        AddressData address
) { }
