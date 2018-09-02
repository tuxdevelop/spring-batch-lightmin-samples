package org.tuxdevelop.spring.batch.lightmin.address_migrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tuxdevelop.spring.batch.lightmin.client.configuration.EnableSpringBatchLightminClient;

@EnableScheduling
@EnableSpringBatchLightminClient
@SpringBootApplication(exclude = {BatchAutoConfiguration.class})
public class AddressMigratorClientApp {

    public static void main(final String[] args) {
        SpringApplication.run(AddressMigratorClientApp.class, args);
    }

}
