package com.producer_api.covid_statistics.infrastructure;

import org.springframework.kafka.core.KafkaTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.producer_api.covid_statistics.core.DomainEvent;
import com.producer_api.covid_statistics.core.DomainEventPublisher;

import org.springframework.stereotype.Component;

@Component
public class KafkaDomainEventPublisher implements DomainEventPublisher{
	private KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper objectMapper;

    public  KafkaDomainEventPublisher(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publish(DomainEvent domainEvent) {
        try {
            String event = this.objectMapper.writeValueAsString(domainEvent);
            this.kafkaTemplate.send("orders",domainEvent.getId(), event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
