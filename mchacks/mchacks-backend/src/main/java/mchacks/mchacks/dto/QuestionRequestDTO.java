package mchacks.mchacks.dto;

public class QuestionRequestDTO {
    private String question;
    private int points;

    public QuestionRequestDTO() {
    }

    public QuestionRequestDTO(String question, int points) {
        this.question = question;
        this.points = points;
    }

    public String getQuestion() {
        return question;
    }

    public int getPoints() {
        return points;
    }
}
