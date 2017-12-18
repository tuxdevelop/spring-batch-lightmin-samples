package org.tuxdevelop.spring.batch.lightmin.samples.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.tuxdevelop.spring.batch.lightmin.server.configuration.EnableSpringBatchLightminServer;

@EnableDiscoveryClient
@SpringBootApplication
@EnableSpringBatchLightminServer
public class ConsulDiscoveryClientLightminServer {

    public static void main(final String[] args) {
        SpringApplication.run(ConsulDiscoveryClientLightminServer.class, args);
    }
}
