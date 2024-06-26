package wisecode.med.api.domain.doctor;

import wisecode.med.api.domain.address.Address;

public record DetailsDoctorData(Long id, String name, String email, String crm, String telephone, Specialty specialty, Address address ) {
    public DetailsDoctorData(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getTelephone(), doctor.getSpecialty(), doctor.getAddress());

        }
    }

