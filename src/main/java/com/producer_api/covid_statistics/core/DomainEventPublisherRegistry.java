package com.producer_api.covid_statistics.core;

import org.springframework.util.Assert;

public class DomainEventPublisherRegistry {
	private static DomainEventPublisher instance;

    public static DomainEventPublisher getInstance() {
        Assert.notNull(instance, "DomainEventPublisher must be set.");
        return instance;
    }

    public static void setInstance(DomainEventPublisher instance) {
        DomainEventPublisherRegistry.instance = instance;
    }

}
