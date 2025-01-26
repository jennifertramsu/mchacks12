package mchacks.mchacks.dto;

import java.util.List;

public class QuestionListDTO {
    private List<QuestionResponseDTO> questions;

    public QuestionListDTO() {
    }

    public QuestionListDTO(List<QuestionResponseDTO> questions) {
        this.questions = questions;
    }

    public List<QuestionResponseDTO> getQuestions() {
        return questions;
    }
}
