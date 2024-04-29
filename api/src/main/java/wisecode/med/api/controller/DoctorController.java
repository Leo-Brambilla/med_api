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
import wisecode.med.api.doctor.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity registration(@RequestBody @Valid DoctorRegistrationData data, UriComponentsBuilder uriBuilder) {
        var doctor = new Doctor(data);
        repository.save(doctor);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailsDoctorData(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorListingData>> findAll(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page =  repository.findAllByActiveTrue(pagination).map(DoctorListingData::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DoctorUpdateData data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.updateInformation(data);

        return ResponseEntity.ok(new DetailsDoctorData(doctor));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.delete();

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity details(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);

        return ResponseEntity.ok(new DetailsDoctorData(doctor));

    }
}
