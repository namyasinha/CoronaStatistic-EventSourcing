package com.producer_api.covid_statistics.core;

public interface DomainEventPublisher {
	void publish(DomainEvent domainEvent);

}
