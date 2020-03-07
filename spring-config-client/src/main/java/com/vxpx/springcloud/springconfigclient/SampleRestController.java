package com.vxpx.springcloud.springconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class SampleRestController {

	@Value("${msg:Config Server is not working. Please check..}")
	private String message;
	
	@GetMapping("/message")
	public String getMessage() {
		System.out.println("Invoked Service getMessage");
		return this.message;
	}
}
