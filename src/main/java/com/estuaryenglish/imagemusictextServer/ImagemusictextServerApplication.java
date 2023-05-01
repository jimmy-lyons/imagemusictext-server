package com.estuaryenglish.imagemusictextServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ImagemusictextServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImagemusictextServerApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello World!";
	}
}
