package com.bankofparis.banky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;

/**
 * Spring boot Banky application main class
 */

@SpringBootApplication(exclude = CassandraAutoConfiguration.class)
public class BankyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankyApplication.class, args);
	}

}
