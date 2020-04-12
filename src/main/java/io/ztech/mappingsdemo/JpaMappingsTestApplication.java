package io.ztech.mappingsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("io.ztech.mappingsdemo")
public class JpaMappingsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaMappingsTestApplication.class, args);
	}

}
