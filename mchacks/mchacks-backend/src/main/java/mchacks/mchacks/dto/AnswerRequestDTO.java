package mchacks.mchacks.dto;

public class AnswerRequestDTO {
    private int id;
    private String answer;
    private boolean correct;

    public AnswerRequestDTO() {
    }

    public AnswerRequestDTO(String answer, boolean correct) {
        this.answer = answer;
        this.correct = correct;
    }

    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean getCorrect() {
        return correct;
    }
}
