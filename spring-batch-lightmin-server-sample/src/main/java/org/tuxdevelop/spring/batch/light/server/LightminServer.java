package org.tuxdevelop.spring.batch.light.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tuxdevelop.spring.batch.lightmin.server.annotation.EnableLightminServer;

@SpringBootApplication
@EnableLightminServer
public class LightminServer {


    public static void main(final String[] args) {
        SpringApplication.run(LightminServer.class, args);
    }
}
