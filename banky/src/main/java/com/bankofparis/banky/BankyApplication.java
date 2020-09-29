package com.bankofparis.banky;

import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.nio.file.Path;

@SpringBootApplication
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class BankyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankyApplication.class, args);
	}

//	Uncomment this block for Astra
	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
		File bundle = astraProperties.getSecureConnectBundle();
		if (bundle != null) {
			return builder -> builder.build();
		} else {
			return builder -> builder.withCloudSecureConnectBundle(bundle.toPath());
		}
	}
}
