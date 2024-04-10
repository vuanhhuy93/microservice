package com.huyva.customer.database.repositoties;

import com.huyva.customer.database.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findFirstByUsernameOrderByCreatedAtDesc(String userName);
}
