package wisecode.med.api.domain.patient;

import wisecode.med.api.domain.doctor.Specialty;

public record PatientListingData(Long id, String name, String email) {

    public PatientListingData(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail());
    }
}
