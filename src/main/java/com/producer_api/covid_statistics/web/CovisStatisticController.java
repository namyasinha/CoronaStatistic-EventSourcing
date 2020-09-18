package com.producer_api.covid_statistics.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.producer_api.covid_statistics.api.DisplayApplicationService;
import com.producer_api.covid_statistics.core.display.Display;
import com.producer_api.covid_statistics.core.display.DisplayId;
import com.producer_api.covid_statistics.model.cases;

@RestController
public class CovisStatisticController {
	
	private DisplayApplicationService displayApplicationService;
	
	public CovisStatisticController(DisplayApplicationService displayApplicationService) {
		this.displayApplicationService=displayApplicationService;
	}
	@GetMapping("/coronaStatistics")
	@CrossOrigin(origins = "http://localhost:4200")
	public cases display() {
		return this.displayApplicationService.display();
	}
	
	

}
