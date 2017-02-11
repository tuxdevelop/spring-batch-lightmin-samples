package org.tuxdevelop.sample.jpa.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tuxdevelop.sample.jpa.batch.persistence.domain.Customer;
import org.tuxdevelop.sample.jpa.batch.persistence.repository.CustomerRepository;

@Component
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    private static final Integer PROCESSED_VALIDATION_STATE = 10;

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerProcessor(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer process(final Customer customer) throws Exception {
        customer.setValidationState(PROCESSED_VALIDATION_STATE);
        return customerRepository.save(customer);
    }
}
