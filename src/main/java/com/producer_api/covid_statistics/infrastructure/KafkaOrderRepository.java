package com.producer_api.covid_statistics.infrastructure;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.producer_api.covid_statistics.core.DomainEvent;
import com.producer_api.covid_statistics.core.display.*;

@Repository
public class KafkaOrderRepository {
	private final Map<DisplayId, Display.Builder> slots = new HashMap<>();
    private final ObjectMapper objectMapper;

    public KafkaOrderRepository(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @KafkaListener(groupId="slot",topics = "orders")
    public void listen(String event) throws IOException {
        DomainEvent domainEvent = this.objectMapper.readValue(event, DomainEvent.class);
        if (!(domainEvent instanceof DisplayDomainEvent)) {
            return;
        }
        DisplayDomainEvent orderDomainEvent = (DisplayDomainEvent) domainEvent;

        DisplayId orderId = orderDomainEvent.getDisplayId();
        Display.Builder builder = slots.getOrDefault(orderId, new Display.Builder());
        slots.put(orderId, orderDomainEvent.apply(builder));
    }

    

}
