package org.tuxdevelop.sample.jpa.batch.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tuxdevelop.sample.jpa.batch.persistence.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
