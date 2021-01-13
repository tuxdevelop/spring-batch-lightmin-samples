package org.tuxdevelop.sample.jpa.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.tuxdevelop.sample.jpa.batch.configuration.ApplicationConfiguration;
import org.tuxdevelop.spring.batch.lightmin.annotation.EnableLightminEmbedded;
import org.tuxdevelop.spring.batch.lightmin.batch.annotation.EnableLightminBatchJpa;
import org.tuxdevelop.spring.batch.lightmin.repository.annotation.EnableLightminJdbcConfigurationRepository;

@SpringBootApplication
@EnableTransactionManagement
@EnableLightminEmbedded
@EnableLightminBatchJpa
@EnableLightminJdbcConfigurationRepository
@EnableJpaRepositories(basePackages = "org.tuxdevelop.sample.jpa.batch.persistence.repository")
public class SampleApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }
}
