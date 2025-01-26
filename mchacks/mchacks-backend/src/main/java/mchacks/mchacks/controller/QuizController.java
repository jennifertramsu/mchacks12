package mchacks.mchacks.controller;

import org.springframework.web.bind.annotation.RestController;

import mchacks.mchacks.dto.SubmissionDTO;
import mchacks.mchacks.model.Player;
import mchacks.mchacks.service.PlayerService;
import mchacks.mchacks.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
public class QuizController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private PlayerService playerService;

    public QuizController(QuestionService questionService, PlayerService playerService) {
        this.questionService = questionService;
        this.playerService = playerService;
    }

    @PostMapping("/quiz/questions/{question_id}/submission")
    public void submitAnswer(@RequestBody SubmissionDTO submission) {
        // Get the correct answer for the question
        int correctAnswer = questionService.getQuestionAnswer(submission.getQuestionId()).getId();
        Player player = playerService.getPlayer(submission.getPlayerId());
        int score = questionService.getQuestion(submission.getQuestionId()).getPoints();
        
        // Check if the submitted answer is correct
        if (submission.getAnswerId() == correctAnswer) {
            // Update the player's score
            playerService.updatePlayer(player.getPatient_id(), player.getScore() + score);
        }
    }
    
}
