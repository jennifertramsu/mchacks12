package mchacks.mchacks.dto;

import java.time.LocalDate;

import mchacks.mchacks.model.Patient;

public class PatientResponseDTO {
    private String id;
    private LocalDate arrival_time;
    private int time_elapsed;
    private String triage_category;
    private String phase;
    private int globalPosition;
    private int categoryPosition;

    public PatientResponseDTO() {}

    public PatientResponseDTO(Patient patient) {
        this.id = patient.getId();
        this.arrival_time = patient.getArrival_time();
        this.time_elapsed = patient.getTime_elapsed();
        this.triage_category = patient.getTriage_category();
        this.phase = patient.getPhase();
        this.globalPosition = patient.getGlobalPosition();
        this.categoryPosition = patient.getCategoryPosition();
    }

    public String getId() {
        return id;
    }

    public LocalDate getArrival_time() {
        return arrival_time;
    }

    public int getTime_elapsed() {
        return time_elapsed;
    }

    public String getTriage_category() {
        return triage_category;
    }

    public String getPhase() {
        return phase;
    }

    public int getGlobalPosition() {
        return globalPosition;
    }

    public int getCategoryPosition() {
        return categoryPosition;
    }  
}
