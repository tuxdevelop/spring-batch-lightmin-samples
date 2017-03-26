package org.tuxdevelop.sample.jpa.batch.configuration.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tuxdevelop.sample.jpa.batch.persistence.domain.Customer;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class CustomerJobConfiguration {

    @Bean
    public Job customerJob(final JobBuilderFactory jobBuilderFactory,
                           final Step customerStep) {
        return jobBuilderFactory
                .get("customerJob")
                .start(customerStep)
                .build();
    }

    @Bean
    public Step customerStep(final StepBuilderFactory stepBuilderFactory,
                             final ItemReader<Customer> customerItemReader,
                             final ItemProcessor<Customer, Customer> customerProcessor,
                             final ItemWriter<Customer> customerItemWriter) {
        return stepBuilderFactory
                .get("customerStep")
                .<Customer, Customer>chunk(10)
                .reader(customerItemReader)
                .processor(customerProcessor)
                .writer(customerItemWriter)
                .build();
    }

    @Bean
    public ItemReader<Customer> customerItemReader(final DataSource dataSource) throws Exception {
        final JdbcCursorItemReader<Customer> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql("SELECT * FROM customer WHERE validation_state = 0");
        reader.setMaxRows(10);
        reader.setRowMapper((resultSet, i) -> {
            final Customer customer = new Customer();
            customer.setCustomerId(resultSet.getLong("customer_id"));
            customer.setFirstName(resultSet.getString("first_name"));
            customer.setLastName(resultSet.getString("last_name"));
            customer.setValidationState(resultSet.getInt("validation_state"));
            return customer;
        });

        reader.afterPropertiesSet();
        return reader;
    }

    @Bean
    public ItemWriter<Customer> customerItemWriter() {
        return customers -> {
            if (customers != null && !customers.isEmpty()) {
                for (final Customer customer : customers) {
                    log.info("Processed: {}", customer);
                }
            }
        };
    }

}
