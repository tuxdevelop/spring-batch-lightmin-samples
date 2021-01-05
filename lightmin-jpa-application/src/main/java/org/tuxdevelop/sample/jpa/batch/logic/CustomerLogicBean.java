package org.tuxdevelop.sample.jpa.batch.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.tuxdevelop.sample.jpa.batch.persistence.domain.Customer;
import org.tuxdevelop.sample.jpa.batch.persistence.repository.CustomerRepository;

import java.util.List;

@Component
public class CustomerLogicBean {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerLogicBean(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(
            readOnly = true,
            transactionManager = "transactionManager")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Transactional(transactionManager = "transactionManager")
    public Customer add(final Customer customer) {
        return customerRepository.save(customer);
    }
}
