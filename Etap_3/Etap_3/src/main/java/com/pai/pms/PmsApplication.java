package com.pai.pms;

import com.pai.pms.model.Apartment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PmsApplication {

	public static void main(String[] args) {
		Apartment apartment = new Apartment();
		SpringApplication.run(PmsApplication.class, args);
	}

}
