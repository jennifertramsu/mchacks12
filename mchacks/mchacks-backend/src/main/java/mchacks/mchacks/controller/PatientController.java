package mchacks.mchacks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mchacks.mchacks.service.PatientService;
import mchacks.mchacks.dto.PatientRequestDTO;
import mchacks.mchacks.dto.PatientResponseDTO;
import mchacks.mchacks.model.Patient;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Add patient
    @PostMapping("/patients")
    public PatientResponseDTO addPatient(@RequestBody PatientRequestDTO patient) {
        Patient p = patientService.createPatient(patient.getId(), patient.getArrival_time(), patient.getTime_elapsed(), patient.getTriage_category(), patient.getPhase(), patient.getGlobalPosition(), patient.getCategoryPosition());
        return new PatientResponseDTO(p);
    }
}
