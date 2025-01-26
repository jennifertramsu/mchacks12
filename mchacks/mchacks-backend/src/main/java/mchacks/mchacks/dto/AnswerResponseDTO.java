package mchacks.mchacks.dto;

import mchacks.mchacks.model.Answer;

public class AnswerResponseDTO {
    private int id;
    private String text;

    public AnswerResponseDTO() {
    }

    public AnswerResponseDTO(Answer answer) {
        this.id = answer.getId();
        this.text = answer.getText();
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
