package edu.iu.habahram.ducksservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DucksServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DucksServiceApplication.class, args);
	}

}
