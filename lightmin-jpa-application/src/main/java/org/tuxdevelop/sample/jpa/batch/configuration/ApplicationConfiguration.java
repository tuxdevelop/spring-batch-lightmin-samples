package org.tuxdevelop.sample.jpa.batch.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.integration.annotation.BridgeFrom;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.tuxdevelop.sample.jpa.batch.persistence.domain.Customer;
import org.tuxdevelop.sample.jpa.batch.persistence.repository.CustomerRepository;
import org.tuxdevelop.spring.batch.lightmin.annotation.EnableLightminEmbedded;
import org.tuxdevelop.spring.batch.lightmin.batch.configuration.JpaSpringBatchLightminBatchConfigurer;
import org.tuxdevelop.spring.batch.lightmin.batch.configuration.SpringBatchLightminBatchConfigurationProperties;
import org.tuxdevelop.spring.batch.lightmin.repository.annotation.EnableLightminJdbcConfigurationRepository;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Slf4j
@Configuration
public class ApplicationConfiguration {

    /*
     * Persistence
     */

    @Bean
    @Primary
    public DataSource dataSource() {
        final EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
        embeddedDatabaseBuilder.addScripts("classpath:org/tuxdevelop/spring/batch/lightmin/repository/schema_h2.sql");
        return embeddedDatabaseBuilder.build();
    }

    /*
     * Data
     */

    @Bean
    public ApplicationRunner applicationRunner(final CustomerRepository customerRepository) {
        return strings -> {
            final Customer customer1 = new Customer();
            customer1.setFirstName("Josh");
            customer1.setLastName("Long");
            customer1.setValidationState(0);
            final Customer customer2 = new Customer();
            customer2.setFirstName("Oliver");
            customer2.setLastName("Gierke");
            customer2.setValidationState(0);
            customerRepository.save(customer1);
            customerRepository.save(customer2);
            log.info("customers: {}", customerRepository.findAll());
        };
    }

}
