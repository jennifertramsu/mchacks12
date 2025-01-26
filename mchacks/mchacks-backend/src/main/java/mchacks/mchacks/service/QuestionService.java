package mchacks.mchacks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mchacks.mchacks.model.Answer;
import mchacks.mchacks.model.Question;
import mchacks.mchacks.dao.QuestionDao;

@Service
public class QuestionService {
    @Autowired
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

    @Transactional
    public void addQuestion(Question question) {
        questionDao.save(question);
    }

    @Transactional
    public void deleteQuestion(int id) {
        questionDao.deleteById(id);
    }

    @Transactional
    public void updateQuestion(Question question) {
        questionDao.save(question);
    }

    @Transactional
    public Answer getQuestionAnswer(int q_id) {
        Question q = questionDao.getQuestionById(q_id);
        return q.getCorrect();
    }

    @Transactional
    public List<Answer> loadQuestion(int q_id) {
        Question q = questionDao.getQuestionById(q_id);
        List<Answer> answers = q.getBank();

        // add correct answer to list
        answers.add(q.getCorrect());

        // shuffle answers
        for (int i = 0; i < answers.size(); i++) {
            int randomIndex = (int) (Math.random() * answers.size());
            Answer temp = answers.get(i);
            answers.set(i, answers.get(randomIndex));
            answers.set(randomIndex, temp);
        }

        return answers;
    }
}
