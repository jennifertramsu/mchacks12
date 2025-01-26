package mchacks.mchacks.service;

import java.util.List;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mchacks.mchacks.model.Question;
import mchacks.mchacks.dao.QuestionDao;

@Service
public class QuestionService {
    @AutoConfigureOrder
    private QuestionDao questionDao;

    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Transactional
    public Question getQuestion() {
        // Retrieve list of all question ids
        List<Integer> questionIds = questionDao.getAllQuestionIds();
        
        // Randomly select a question id
        int randomIndex = (int) (Math.random() * questionIds.size());
        int randomQuestionId = questionIds.get(randomIndex);
        
        // Retrieve question by id
        return questionDao.getQuestionById(randomQuestionId);
    }

}
