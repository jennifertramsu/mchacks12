package mchacks.mchacks.dto;

import java.util.List;

import mchacks.mchacks.dto.AnswerResponseDTO;

public class AnswerListDTO {
    private List<AnswerResponseDTO> answers;

    public AnswerListDTO() {
    }

    public AnswerListDTO(List<AnswerResponseDTO> answers) {
        this.answers = answers;
    }

    public List<AnswerResponseDTO> getAnswers() {
        return answers;
    }

    public int size() {
        return answers.size();
    }
}

