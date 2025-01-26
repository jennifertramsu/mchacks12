package mchacks.mchacks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mchacks.mchacks.dao.AnswerDao;
import mchacks.mchacks.model.Answer;

@Service
public class AnswerService {
    @Autowired
    private AnswerDao answerDao;

    public AnswerService(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    @Transactional
    public void addAnswer(Answer answer) {
        answerDao.save(answer);
    }

    @Transactional
    public void deleteAnswer(int id) {
        answerDao.deleteById(id);
    }

    @Transactional
    public void updateAnswer(Answer answer) {
        answerDao.save(answer);
    }   
}
