package com.vxpx.springcloud.springconfigclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClientApplication.class, args);
	}

	@Autowired
	public void setEnv(Environment env) {
		System.out.println("Invoke setEnv .. " + env.getProperty("msg"));
	}
}
