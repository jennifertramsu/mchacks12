package mchacks.mchacks.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mchacks.mchacks.model.Question;

public interface QuestionDao extends CrudRepository<Question, Integer> {
    // Get all question ids
    List<Integer> getAllQuestionIds();

    // Get question by id
    Question getQuestionById(int id);
    
}
