package com.producer_api.covid_statistics.core.display;

import com.producer_api.covid_statistics.model.*;
public class DisplayCreatedDomainEvent extends DisplayDomainEvent {
	
	private cases statistic;
	
	public DisplayCreatedDomainEvent() {}
	
	public DisplayCreatedDomainEvent(DisplayId displayId, cases statistic) {
		// TODO Auto-generated constructor stub
		super(displayId);
		this.statistic=statistic;
	}

	@Override
    public Display.Builder apply(Display.Builder builder) {
        return builder
                .setCases(statistic)
                .setDisplayId(getDisplayId());
                
                
    }

}
