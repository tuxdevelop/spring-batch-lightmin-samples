package org.tuxdevelop.spring.batch.lightmin.address_migrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tuxdevelop.spring.batch.lightmin.client.discovery.annotation.EnableLightminClientConsul;
import org.tuxdevelop.spring.batch.lightmin.repository.annotation.EnableLightminRemoteConfigurationRepository;

@EnableScheduling
@EnableLightminClientConsul
@EnableLightminRemoteConfigurationRepository
@SpringBootApplication(exclude = {BatchAutoConfiguration.class})
public class AddressMigratorConsulApp {

    public static void main(final String[] args) {
        SpringApplication.run(AddressMigratorConsulApp.class, args);
    }

}
