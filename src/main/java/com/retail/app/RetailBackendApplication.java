package com.retail.app;

import com.retail.app.util.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class RetailBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailBackendApplication.class, args);
	}


}

@Component
class AppInitializer implements CommandLineRunner{

	@Value("${app.version}")
	private String appVersion;

	@Autowired
	private ApplicationProperties applicationProperties;
	@Override
	public void run(String... args) throws Exception {

		System.out.println("The app version is : "+appVersion);
		System.out.println("Application Properties class : "+applicationProperties.getVersion());
		System.out.println("Ftp properties : "+applicationProperties);
	}
}