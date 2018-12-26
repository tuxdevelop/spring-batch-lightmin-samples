package org.tuxdevelop.spring.batch.lightmin.samples.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.tuxdevelop.spring.batch.lightmin.repository.annotation.EnableLightminJdbcConfigurationRepository;
import org.tuxdevelop.spring.batch.lightmin.repository.server.configuration.EnableLightminRepositoryServer;
import org.tuxdevelop.spring.batch.lightmin.server.annotation.EnableLightminServer;

import javax.sql.DataSource;

@EnableDiscoveryClient
@SpringBootApplication
@EnableLightminServer
@EnableLightminJdbcConfigurationRepository
@EnableLightminRepositoryServer
public class EurekaDiscoveryClientLightminServer {

    public static void main(final String[] args) {
        SpringApplication.run(EurekaDiscoveryClientLightminServer.class, args);
    }

    @Bean
    public DataSource dataSource() {
        final EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        return embeddedDatabaseBuilder
                .addScript("classpath:org/tuxdevelop/spring/batch/lightmin/repository/drop_schema_h2.sql")
                .addScript("classpath:org/tuxdevelop/spring/batch/lightmin/repository/schema_h2.sql")
                .addScript("classpath:org/springframework/batch/core/schema-drop-h2.sql")
                .addScript("classpath:org/springframework/batch/core/schema-h2.sql")
                .addScript("classpath:inserts_04.sql")
                .setType(EmbeddedDatabaseType.H2).build();
    }

}
