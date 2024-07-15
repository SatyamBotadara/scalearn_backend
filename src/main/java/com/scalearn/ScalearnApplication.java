package com.scalearn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scalearn.dto.ScalearnProps;

@SpringBootApplication
public class ScalearnApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScalearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		System.out.println(ScalearnProps.BasePathDto.basePath);
	}
}
