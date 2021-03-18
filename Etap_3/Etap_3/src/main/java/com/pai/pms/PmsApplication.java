package com.pai.pms;

import com.pai.pms.model.Apartments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PmsApplication {

	public static void main(String[] args) {
		Apartments apartments = new Apartments();
		SpringApplication.run(PmsApplication.class, args);
	}

}
