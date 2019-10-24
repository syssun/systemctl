package com.sys.systemctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class TestKafka {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    public static void main(String[] args) {

    }
}
