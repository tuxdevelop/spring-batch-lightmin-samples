package org.tuxdevelop.spring.batch.lightmin.address_migrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tuxdevelop.spring.batch.lightmin.client.configuration.EnableSpringBatchLightminClient;

@EnableScheduling
@SpringBootApplication
@EnableSpringBatchLightminClient
public class AddressMigratorWarApp extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(AddressMigratorWarApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(AddressMigratorWarApp.class);
    }

}
