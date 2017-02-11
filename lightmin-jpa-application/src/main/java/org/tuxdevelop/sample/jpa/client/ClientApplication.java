package org.tuxdevelop.sample.jpa.client;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.tuxdevelop.sample.jpa.batch.persistence.domain.Customer;

import java.util.List;

@Slf4j
public class ClientApplication {

    public static void main(final String[] args) {

        final RestTemplate restTemplate = new RestTemplate();

        log.info("Adding customer...");
        final Customer customer = new Customer();
        customer.setFirstName("Donnie");
        customer.setLastName("Darko");
        customer.setValidationState(0);
        final ResponseEntity<Customer> response = restTemplate.postForEntity("http://localhost:8080/customers", customer, Customer.class);
        log.info("Added customer: {} , with status: {}", response.getBody(), response.getStatusCode());
        log.info("Fetching all customers");
        final ResponseEntity<List> customersResponse = restTemplate.getForEntity("http://localhost:8080/customers", List.class);
        final List<Customer> customers = customersResponse.getBody();
        log.info("Fetched all customers: {}", customers);
    }


}
