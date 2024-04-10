package com.huyva.customer.domains;

import com.huyva.customer.database.entities.Customer;
import com.huyva.customer.database.repositoties.CustomerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Log4j2
@Component
public class CustomerDomain {

    private CustomerRepository customerRepository;

    public CustomerDomain(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerByUserName(String userName) {
        log.info("querty to Db find customer with username {}", userName);

        Customer customer = customerRepository.findFirstByUsernameOrderByCreatedAtDesc(userName);

        log.info("find customer on db success . return value:  {} ",
                customer == null ? "not found on db" : " customer with id " + customer.getId());

        return customer;

    }
    public void saveCustomer(Customer customer){
        log.info("{} START" , customer.getId() == null ? " save customer" : "update customer with id " + customer.getId());
        customerRepository.save(customer);
        log.info("{} DONE" , customer.getId() == null ? " save customer" : "update customer with id " + customer.getId());
    }
}
