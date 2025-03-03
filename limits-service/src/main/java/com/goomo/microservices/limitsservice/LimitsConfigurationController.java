package com.goomo.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goomo.microservices.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	// To use the class properties
	@Autowired
	Configuration configuration;
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
		//return new LimitConfiguration(123456, 0);
	}

}
