package wisecode.med.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import wisecode.med.api.domain.doctor.*;
import wisecode.med.api.domain.patient.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity registration(@RequestBody @Valid PatientRegistrationData data, UriComponentsBuilder uriBuilder) {
        var patient = new Patient(data);
        repository.save(patient);

        var uri = uriBuilder.path("/patient/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailsPatientData(patient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientListingData>> findAll(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page =  repository.findAllByActiveTrue(pagination).map(PatientListingData::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid PatientUpdateData data) {
        var patient = repository.getReferenceById(data.id());
        patient.updateInformation(data);

        return ResponseEntity.ok(new DetailsPatientData(patient));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        patient.delete();

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity details(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);

        return ResponseEntity.ok(new DetailsPatientData(patient));

    }
}
