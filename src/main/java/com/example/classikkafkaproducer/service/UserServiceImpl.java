package com.example.classikkafkaproducer.service;

import com.example.classikkafkaproducer.entity.Order;
import com.example.classikkafkaproducer.entity.User;
import com.example.classikkafkaproducer.kafka.KafkaProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final KafkaProducer producer;


    public User getUserById(String id) throws JsonProcessingException
    {
        System.out.println("Get from db - imitation...");
        var user = User.builder()
                .id(id)
                .name("name")
                .build();

        producer.sendMessage(user);

        return user;
    }



}
