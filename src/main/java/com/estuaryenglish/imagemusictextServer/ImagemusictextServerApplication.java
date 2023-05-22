package com.estuaryenglish.imagemusictextServer;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class ImagemusictextServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImagemusictextServerApplication.class, args);
	}
}
