package wisecode.med.api.domain.patient;

import wisecode.med.api.domain.address.Address;

public record DetailsPatientData(Long id, String name, String email, String telephone, Address address ) {
    public DetailsPatientData(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getTelephone(), patient.getAddress());

        }
    }

