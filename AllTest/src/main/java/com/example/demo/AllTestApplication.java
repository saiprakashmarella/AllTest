package com.example.demo;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AllTestApplication {

	public static void main(String[] args) {
		
		final Logger Logg=LogManager.getLogger(AllTestApplication.class.getName());
		Logg.info("Server started");
		SpringApplication.run(AllTestApplication.class, args);
	}

}
