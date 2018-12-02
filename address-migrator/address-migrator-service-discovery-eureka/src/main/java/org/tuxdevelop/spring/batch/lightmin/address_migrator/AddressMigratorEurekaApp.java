package org.tuxdevelop.spring.batch.lightmin.address_migrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tuxdevelop.spring.batch.lightmin.client.discovery.annotation.EnableLightminClientEureka;
import org.tuxdevelop.spring.batch.lightmin.repository.annotation.EnableLightminRemoteConfigurationRepository;

@EnableScheduling
@EnableLightminClientEureka
@EnableLightminRemoteConfigurationRepository
@SpringBootApplication(exclude = {BatchAutoConfiguration.class})
public class AddressMigratorEurekaApp {

    public static void main(final String[] args) {
        SpringApplication.run(AddressMigratorEurekaApp.class, args);
    }

}
