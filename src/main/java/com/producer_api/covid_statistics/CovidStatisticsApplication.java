package com.producer_api.covid_statistics;


import com.producer_api.covid_statistics.core.DomainEventPublisher;
import com.producer_api.covid_statistics.core.DomainEventPublisherRegistry;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CovidStatisticsApplication {
	
	@Autowired
	private DomainEventPublisher domainEventPublisher;

	public static void main(String[] args) {
		SpringApplication.run(CovidStatisticsApplication.class, args);
		
	}
	@PostConstruct
	public void setDomainEventPublisher() {
		DomainEventPublisherRegistry.setInstance(domainEventPublisher);
	}

}
