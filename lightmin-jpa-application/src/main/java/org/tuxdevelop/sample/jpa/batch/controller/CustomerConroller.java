package org.tuxdevelop.sample.jpa.batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tuxdevelop.sample.jpa.batch.logic.CustomerLogicBean;
import org.tuxdevelop.sample.jpa.batch.persistence.domain.Customer;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerConroller {

    private final CustomerLogicBean customerLogicBean;

    @Autowired
    public CustomerConroller(final CustomerLogicBean customerLogicBean) {
        this.customerLogicBean = customerLogicBean;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> findAll() {
        final List<Customer> customers = customerLogicBean.findAll();
        return ResponseEntity.ok(customers);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> add(@RequestBody final Customer customer) {
        final Customer savedCustomer = customerLogicBean.add(customer);
        return ResponseEntity.ok(savedCustomer);
    }

}
