package mchacks.mchacks.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class QueueController {
    @GetMapping(value = "/queue")
    public List<Object> getQueue() {
        String url = "https://ifem-award-mchacks-2025.onrender.com/api/v1";
        RestTemplate restTemplate = new RestTemplate();

        Object queue = restTemplate.getForObject(url + "/queue", Object.class);
        return Arrays.asList(queue);
    }
    
}
