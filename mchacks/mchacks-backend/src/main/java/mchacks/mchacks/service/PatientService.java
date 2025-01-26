package mchacks.mchacks.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mchacks.mchacks.dao.PatientDao;
import mchacks.mchacks.model.Patient;

@Service
public class PatientService {
    @Autowired
    private PatientDao patientDao;

    public PatientService(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public Patient createPatient(String aId, LocalDate aArrival_time, int aTime_elapsed, String aTriage_category, String aPhase, int aGlobalPosition, int aCategoryPosition) {
        Patient patient = new Patient(aId, aArrival_time, aTime_elapsed, aTriage_category, aPhase, aGlobalPosition, aCategoryPosition);
        patientDao.save(patient);
        return patient;
    }

}
