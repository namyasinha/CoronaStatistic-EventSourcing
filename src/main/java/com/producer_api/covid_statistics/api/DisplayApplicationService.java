package com.producer_api.covid_statistics.api;

import com.producer_api.covid_statistics.model.cases;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.producer_api.covid_statistics.core.display.*;

@Service
public class DisplayApplicationService {
	
	public cases display() {
		RestTemplate resttemplate=new RestTemplate();
		cases st=resttemplate.getForObject("http://covid19-india-adhikansh.herokuapp.com/states",cases.class);
		return new Display.Builder()
				.setDisplayId(new DisplayId())
				.setCases(st)
				.build()
				.getCases();
				
		
	}
	

}
