package com.producer_api.covid_statistics.core.display;

import com.producer_api.covid_statistics.core.DomainEvent;
public  abstract class DisplayDomainEvent implements DomainEvent<Display.Builder> {
	private DisplayId displayId;
	
	DisplayDomainEvent(){}
	
	DisplayDomainEvent(DisplayId displayId) {
        this.displayId = displayId;
    }

    public DisplayId getDisplayId() {
        return displayId;
    }

    @Override
    public String getId() {
        return displayId.getValue();
    }
	

}
