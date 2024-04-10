package com.huyva.customer.models.response;

import com.huyva.customer.models.ApiException;
import com.huyva.customer.models.request.register.RegisterRequest;
import com.huyva.customer.services.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService =customerService;
    }
    @PostMapping("/register")
    public BaseResponse register(@RequestParam RegisterRequest request) throws ApiException {
        return customerService.registerCustomer(request);
    }
}
