package com.example.classikkafkaproducer.kafka;

import com.example.classikkafkaproducer.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public String sendMessage(User user) throws JsonProcessingException {
        String userAsMessage = objectMapper.writeValueAsString(user);
        kafkaTemplate.send(orderTopic, userAsMessage);

        log.info("user produced {}", userAsMessage);

        return "message sent";
    }

}