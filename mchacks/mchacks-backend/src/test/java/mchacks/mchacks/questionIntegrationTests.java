package mchacks.mchacks;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import mchacks.mchacks.dao.AnswerDao;
import mchacks.mchacks.dao.QuestionDao;
import mchacks.mchacks.dto.QuestionListDTO;
import mchacks.mchacks.dto.QuestionRequestDTO;
import mchacks.mchacks.dto.QuestionResponseDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class questionIntegrationTests {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private AnswerDao answerDao;

    @BeforeEach
    @AfterEach
    public void tearDown() {
        questionDao.deleteAll();
        answerDao.deleteAll();
    }

    @Test
    public void testCreateQuestion() {
        QuestionRequestDTO q = new QuestionRequestDTO("What is the capital of Canada?", 10);
        ResponseEntity<QuestionResponseDTO> response = restTemplate.postForEntity("/quiz/questions", q, QuestionResponseDTO.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());
        assertNotNull(response.getBody().getQuestion());
    }

    @Test
    public void getAllQuestions() {
        // Create four questions
        QuestionRequestDTO q1 = new QuestionRequestDTO("What is the capital of Canada?", 10);
        restTemplate.postForEntity("/quiz/questions", q1, QuestionResponseDTO.class);
        QuestionRequestDTO q2 = new QuestionRequestDTO("What is the capital of the United States?", 10);
        restTemplate.postForEntity("/quiz/questions", q2, QuestionResponseDTO.class);
        QuestionRequestDTO q3 = new QuestionRequestDTO("What is the capital of Mexico?", 10);
        restTemplate.postForEntity("/quiz/questions", q3, QuestionResponseDTO.class);
        QuestionRequestDTO q4 = new QuestionRequestDTO("What is the capital of Brazil?", 10);
        restTemplate.postForEntity("/quiz/questions", q4, QuestionResponseDTO.class);
        
        ResponseEntity<QuestionListDTO> response = restTemplate.getForEntity("/quiz/questions", QuestionListDTO.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println(response.getBody().getQuestions());
    }
    
}
