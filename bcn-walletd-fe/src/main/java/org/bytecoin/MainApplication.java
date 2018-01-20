package org.bytecoin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class MainApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(MainApplication.class)
			.properties("spring.profiles.active=development")
			.run(args);
	}
}