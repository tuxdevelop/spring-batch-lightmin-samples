package org.tuxdevelop.sample.jpa.batch.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
import org.tuxdevelop.spring.batch.lightmin.server.configuration.EnableEmbeddedSpringBatchLightminServer;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
@EnableEmbeddedSpringBatchLightminServer
@ComponentScan(basePackages = "org.tuxdevelop.sample.jpa.batch")
@EnableJpaRepositories(basePackages = "org.tuxdevelop.sample.jpa.batch.persistence.repository")
public class ApplicationConfiguration {

    /*
     * Persistence
     */

    @Bean
    @Qualifier("dataSource")
    @Primary
    public DataSource dataSource() {
        final EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
        embeddedDatabaseBuilder.addScripts("classpath:org/tuxdevelop/spring/batch/lightmin/schema_h2.sql");
        return embeddedDatabaseBuilder.build();
    }

    @Bean
    @Qualifier("jpaDataSource")
    public DataSource jpaDataSource() {
        final EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
        return embeddedDatabaseBuilder.build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory,
                                                         @Qualifier("jpaDataSource") final DataSource jpaDataSource) {
        final JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setDataSource(jpaDataSource);
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        jpaTransactionManager.afterPropertiesSet();
        return jpaTransactionManager;
    }

    @Bean
    @Qualifier("entityManagerFactory")
    public EntityManagerFactory entityManagerFactory(@Qualifier("jpaDataSource") final DataSource jpaDataSource) {
        final HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(false);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.H2);

        final LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new
                LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setPersistenceUnitName("samplePU");
        localContainerEntityManagerFactoryBean.setDataSource(jpaDataSource);
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        localContainerEntityManagerFactoryBean.setPackagesToScan("org.tuxdevelop.sample.jpa.batch.persistence.domain");
        localContainerEntityManagerFactoryBean.afterPropertiesSet();
        return localContainerEntityManagerFactoryBean.getObject();
    }

    /*
     * Data
     */

    @Bean
    public CommandLineRunner commandLineRunner(final CustomerRepository customerRepository) {
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
