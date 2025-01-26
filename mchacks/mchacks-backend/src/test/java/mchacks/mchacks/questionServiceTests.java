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

@SpringBootTest
public class questionServiceTests {
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private AnswerDao answerDao;

    @AfterEach
    public void tearDown() {
        questionDao.deleteAll();
        answerDao.deleteAll();
    }

    @Test
    public void testCreateQuestion() {
        Question q = new Question("What is the capital of Canada?", 10);
        questionDao.save(q);
        assertEquals(1, questionDao.count());
    }

    @Test
    public void addAnswerToQuestionCorrect() {
        Question q = new Question("What is the capital of Canada?", 10);
        questionDao.save(q);
        Answer a = new Answer("Ottawa");
        answerDao.save(a);
        q.addBank(a);
        q.setCorrect(a);
        questionDao.save(q);
        assertEquals(a, q.getCorrect());
    }

    @Test
    public void addAnswersToQuestionBank() {
        Question q = new Question("What is the capital of Canada?", 10);
        questionDao.save(q);

        Answer a1 = new Answer("Ottawa");
        answerDao.save(a1);
        q.addBank(a1);

        Answer a2 = new Answer("Toronto");
        answerDao.save(a2);
        q.addBank(a2);

        Answer a3 = new Answer("Montreal");
        answerDao.save(a3);
        q.addBank(a3);

        q.setCorrect(a1);

        questionDao.save(q);
        assertEquals(3, q.getBank().size());
    }
}
