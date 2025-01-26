package mchacks.mchacks.dto;

import mchacks.mchacks.model.Answer;

public class AnswerResponseDTO {
    private String text;

    public AnswerResponseDTO() {
    }

    public AnswerResponseDTO(Answer answer) {
        this.text = answer.getText();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
