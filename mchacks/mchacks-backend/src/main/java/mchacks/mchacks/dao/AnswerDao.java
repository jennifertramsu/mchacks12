package mchacks.mchacks.dao;

import org.springframework.data.repository.CrudRepository;

import mchacks.mchacks.model.Answer;

public interface AnswerDao extends CrudRepository<Answer, Integer> {
}
