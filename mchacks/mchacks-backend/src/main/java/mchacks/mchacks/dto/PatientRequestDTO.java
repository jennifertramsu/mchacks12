package mchacks.mchacks.dto;

import java.time.LocalDate;

public class PatientRequestDTO {
    private String id;
    private LocalDate arrival_time;
    private int time_elapsed;
    private String triage_category;
    private String phase;
    private int globalPosition;
    private int categoryPosition;

    public PatientRequestDTO(String id, LocalDate arrival_time, int time_elapsed, String triage_category, String phase, int globalPosition, int categoryPosition) {
        this.id = id;
        this.arrival_time = arrival_time;
        this.time_elapsed = time_elapsed;
        this.triage_category = triage_category;
        this.phase = phase;
        this.globalPosition = globalPosition;
        this.categoryPosition = categoryPosition;
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
