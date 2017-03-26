package org.tuxdevelop.sample.jpa.batch;

import org.springframework.boot.SpringApplication;
import org.tuxdevelop.sample.jpa.batch.configuration.ApplicationConfiguration;


public class SampleApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ApplicationConfiguration.class, args);
    }
}
