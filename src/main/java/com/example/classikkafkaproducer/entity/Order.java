package com.example.classikkafkaproducer.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    private String id;
    private String description;

}
