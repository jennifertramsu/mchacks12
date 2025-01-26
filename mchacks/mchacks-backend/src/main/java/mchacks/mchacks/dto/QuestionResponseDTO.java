package mchacks.mchacks.dto;

import mchacks.mchacks.model.Question;
import mchacks.mchacks.model.Answer;

import java.util.ArrayList;
import java.util.List;

public class QuestionResponseDTO {
    private String question;
    private int points;
    private int id;
    private AnswerListDTO answers;

    private QuestionResponseDTO() {}

    public QuestionResponseDTO(Question question) {
        this.question = question.getText();
        this.points = question.getPoints();
        this.id = question.getId();
        List<AnswerResponseDTO> answers = new ArrayList<>();
        for (Answer answer : question.getBank()) {
            answers.add(new AnswerResponseDTO(answer));
        }
        this.answers = new AnswerListDTO(answers);
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

    public AnswerListDTO getAnswers() {
        return answers;
    }
}
