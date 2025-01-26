package mchacks.mchacks.dto;

import mchacks.mchacks.model.Question;

public class QuestionResponseDTO {
    private String question;
    private int points;
    private int id;

    private QuestionResponseDTO() {}

    public QuestionResponseDTO(Question question) {
        this.question = question.getText();
        this.points = question.getPoints();
        this.id = question.getId();
    }

    public String getQuestion() {
        return question;
    }

    public int getPoints() {
        return points;
    }

    public int getId() {
        return id;
    }
}
