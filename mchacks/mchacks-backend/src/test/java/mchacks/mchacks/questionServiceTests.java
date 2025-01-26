package mchacks.mchacks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mchacks.mchacks.dao.AnswerDao;
import mchacks.mchacks.dao.QuestionDao;
import mchacks.mchacks.model.Answer;
import mchacks.mchacks.model.Question;
import mchacks.mchacks.service.QuestionService;

@SpringBootTest
public class questionServiceTests {
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private AnswerDao answerDao;
    @Autowired
    private QuestionService questionService;

    @AfterEach
    public void tearDown() {
        questionDao.deleteAll();
        answerDao.deleteAll();
    }

    @Test
    public void testCreateQuestion() {
        questionService.createQuestion("What is the capital of Canada?", 10);
        assertEquals(1, questionDao.count());
    }

    @Test
    public void addAnswerToQuestionCorrect() {
        Question q = questionService.createQuestion("What is the capital of Canada?", 10);
        Answer a = questionService.createAnswer(q.getId(), "Ottawa", true);

        Question q2 = questionDao.getQuestionById(q.getId());
        
        assertEquals(1, questionDao.count());
        assertEquals(a.getId(), q2.getCorrect().getId());
        assertEquals(1, answerDao.count());
    }

    @Test
    public void addAnswersToQuestionBank() {
        Question q = questionService.createQuestion("What is the capital of Canada?", 10);
        Answer a1 = questionService.createAnswer(q.getId(), "Ottawa", true);
        Answer a2 = questionService.createAnswer(q.getId(), "Toronto", false);
        Answer a3 = questionService.createAnswer(q.getId(), "Montreal", false);

        Question q2 = questionDao.getQuestionById(q.getId());
        
        assertEquals(1, questionDao.count());
        assertEquals(a1.getId(), q2.getCorrect().getId());
        System.out.println(q2.getBank());
    }
}
