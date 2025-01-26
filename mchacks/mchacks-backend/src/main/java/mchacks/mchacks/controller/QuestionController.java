package mchacks.mchacks.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import mchacks.mchacks.service.QuestionService;
import mchacks.mchacks.dto.AnswerRequestDTO;
import mchacks.mchacks.dto.AnswerResponseDTO;
import mchacks.mchacks.dto.QuestionListDTO;
import mchacks.mchacks.dto.QuestionRequestDTO;
import mchacks.mchacks.dto.QuestionResponseDTO;
import mchacks.mchacks.model.Answer;
import mchacks.mchacks.model.Question;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin(origins = "*")
@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/quiz/questions")
    public QuestionListDTO getQuestions() {
        List<Question> q = questionService.getAllQuestions();
        List<QuestionResponseDTO> questions = new ArrayList<>();
        for (Question question : q) {
            questions.add(new QuestionResponseDTO(question));
        }
        return new QuestionListDTO(questions);        
    }

    @GetMapping("/quiz/questions/random")
    public QuestionResponseDTO getRandomQuestion() {
        Question q = questionService.getRandomQuestion();
        return new QuestionResponseDTO(q);
    }

    @GetMapping("/quiz/questions/{question_id}/answer")
    public List<AnswerResponseDTO> getOptions(@PathVariable("question_id") int question_id) {
        List<Answer> a = questionService.loadQuestion(question_id);
        List<AnswerResponseDTO> answers = new ArrayList<>();
        for (Answer answer : a) {
            answers.add(new AnswerResponseDTO(answer));
        }
        return answers;
    }

    @PostMapping("/quiz/questions")
    public QuestionResponseDTO createQuestion(@RequestBody QuestionRequestDTO question) {
        Question q = questionService.createQuestion(question.getQuestion(), question.getPoints());
        return new QuestionResponseDTO(q);
    }

    @PostMapping("/quiz/questions/{question_id}/answer")
    public AnswerResponseDTO postMethodName(@RequestBody AnswerRequestDTO answer, @PathVariable("question_id") int question_id) {
        Answer a = questionService.createAnswer(question_id, answer.getAnswer(), answer.getCorrect());   
        return new AnswerResponseDTO(a);
    }    
}