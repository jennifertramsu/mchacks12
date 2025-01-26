package mchacks.mchacks.dto;

public class SubmissionDTO {
    private String player_id;
    private int questionId;
    private int answerId;

    public SubmissionDTO(String player_id, int questionId, int answer) {
        this.player_id = player_id;
        this.questionId = questionId;
        this.answerId = answer;
    }

    public String getPlayerId() {
        return player_id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getAnswerId() {
        return answerId;
    }
}
