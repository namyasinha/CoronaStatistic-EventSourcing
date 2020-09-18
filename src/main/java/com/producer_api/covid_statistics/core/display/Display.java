package com.producer_api.covid_statistics.core.display;

import com.producer_api.covid_statistics.model.*;

import com.producer_api.covid_statistics.core.*;
public class Display {
	private DisplayId displayId;
	private cases cases;
	
	public Display() {}
	
	public Display(DisplayId displayId, cases statistic) {
		// TODO Auto-generated constructor stub
		this.displayId=displayId;
		this.cases=statistic;
	}

	public DisplayId getDisplayId() {
		return displayId;
		
	}
	
	public cases getCases() {
		return cases;
	}
	
	public static class Builder{
		private DisplayId displayId;
		private cases statistic;
		
		public Builder() {}
		
		public Builder setDisplayId(DisplayId displayId) {
			this.displayId = displayId;
			return this;
		}
		
		public Builder setCases(cases statistic) {
			this.statistic=statistic;
			return this;
		}
		
		public Display build() {
            Display display = buildWithoutEvent();
            DomainEventPublisherRegistry.getInstance()
                    .publish(new DisplayCreatedDomainEvent(displayId, statistic));
            return display;
        }

        public Display buildWithoutEvent() {
            return new Display(displayId,statistic)  ;
        }
		
		
	}


}
