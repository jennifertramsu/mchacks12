package mchacks.mchacks.dao;

import org.springframework.data.repository.CrudRepository;

import mchacks.mchacks.model.Patient;

public interface PatientDao extends CrudRepository<Patient, String> {
    Patient findPatientById(String id);
    void deletePatientById(String id);
    void deleteAll();   
}
