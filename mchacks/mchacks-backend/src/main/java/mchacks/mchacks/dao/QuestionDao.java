package mchacks.mchacks.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mchacks.mchacks.model.Question;

public interface QuestionDao extends CrudRepository<Question, Integer> {
    // Get all question ids
    @Query("SELECT id FROM Question")
    List<Integer> getAllQuestionIds();

    // Get question by id
    Question getQuestionById(int id);

    // Get all
    List<Question> findAll();
}
