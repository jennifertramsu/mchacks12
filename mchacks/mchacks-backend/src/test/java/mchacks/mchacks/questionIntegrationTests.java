package mchacks.mchacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import mchacks.mchacks.dao.AnswerDao;
import mchacks.mchacks.dao.QuestionDao;
import mchacks.mchacks.dto.AnswerRequestDTO;
import mchacks.mchacks.dto.AnswerResponseDTO;
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
        System.out.println(response.getBody().getQuestion());

        QuestionResponseDTO qr = restTemplate.getForObject("/quiz/questions/" + response.getBody().getId(), QuestionResponseDTO.class);
        assertNotNull(qr);
        assertNotNull(qr.getQuestion());
        assertEquals("What is the capital of Canada?", qr.getQuestion());
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
        //System.out.println(response.getBody().getQuestions());
        assertEquals(4, response.getBody().size());
    }

    @Test
    public void addAnswerToQuestion() {
        // Create a question
        QuestionRequestDTO q = new QuestionRequestDTO("What is the capital of Canada?", 10);
        ResponseEntity<QuestionResponseDTO> response = restTemplate.postForEntity("/quiz/questions", q, QuestionResponseDTO.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());
        assertNotNull(response.getBody().getQuestion());
        System.out.println(response.getBody().getQuestion());

        // Add an answer to the question
        AnswerRequestDTO a1 = new AnswerRequestDTO("Ottawa", true);

        ResponseEntity<AnswerResponseDTO> ar1 = restTemplate.postForEntity("/quiz/questions/" + response.getBody().getId() + "/answers", a1, AnswerResponseDTO.class);

        assertNotNull(ar1);
        assertNotNull(ar1.getBody());
        System.out.println(ar1.getBody().getText());        

        // Check question
        System.out.println(response.getBody().getId());
        ResponseEntity<QuestionResponseDTO> qr = restTemplate.getForEntity("/quiz/questions/" + response.getBody().getId(), QuestionResponseDTO.class);
        assertNotNull(qr);
        assertNotNull(qr.getBody());
        assertEquals("What is the capital of Canada?", qr.getBody().getQuestion());
        System.out.println(qr.getBody().getAnswers().getAnswers());
    }
}
