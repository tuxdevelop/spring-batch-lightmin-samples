package org.tuxdevelop.spring.batch.lightmin.address_migrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tuxdevelop.spring.batch.lightmin.configuration.EnableSpringBatchLightminUI;

@EnableScheduling
@EnableSpringBatchLightminUI
@SpringBootApplication(exclude = {BatchAutoConfiguration.class})
public class AddressMigratorApp extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(AddressMigratorApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<AddressMigratorApp> applicationClass = AddressMigratorApp.class;

}
