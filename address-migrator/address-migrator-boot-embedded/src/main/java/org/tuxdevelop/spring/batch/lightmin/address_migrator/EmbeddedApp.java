package org.tuxdevelop.spring.batch.lightmin.address_migrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tuxdevelop.spring.batch.lightmin.annotation.EnableLightminEmbedded;
import org.tuxdevelop.spring.batch.lightmin.repository.annotation.EnableLightminJdbcConfigurationRepository;

@EnableScheduling
@EnableLightminEmbedded
@EnableLightminJdbcConfigurationRepository
@SpringBootApplication
public class EmbeddedApp {

    public static void main(final String[] args) {
        SpringApplication.run(EmbeddedApp.class, args);
    }

}
