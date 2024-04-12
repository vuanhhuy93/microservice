package com.huyva.customer.services;

import com.huyva.customer.domains.CustomerDomain;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class LoginService {
    private CustomerDomain customerDomain;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public LoginService(CustomerDomain customerDomain){
        this.customerDomain = customerDomain;
    }
}
