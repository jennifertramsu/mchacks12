package mchacks;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import mchacks.mchacks.controller.QueueController;

public class Controller {
    // Test QueueController

    // Test getQueue
    @Test
    public void testGetQueue() {
        // Test getQueue
        QueueController queueController = new QueueController();
        List<Object> queue = queueController.getQueue();
        // Print
        System.out.println(queue);
        assertNotNull(queue);
    }
}
