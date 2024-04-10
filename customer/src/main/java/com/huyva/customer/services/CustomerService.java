package com.huyva.customer.services;

import com.huyva.customer.database.entities.Customer;
import com.huyva.customer.domains.CustomerDomain;
import com.huyva.customer.models.ApiException;
import com.huyva.customer.models.ERROR;
import com.huyva.customer.models.request.register.RegisterRequest;
import com.huyva.customer.models.response.BaseResponse;
import com.huyva.customer.utils.ValidationUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CustomerService {

    private CustomerDomain customerDomain;

    public CustomerService(CustomerDomain customerDomain){
        this.customerDomain = customerDomain;
    }
    public BaseResponse registerCustomer(RegisterRequest request) throws ApiException{

        log.info("registerCustomer with username {}" , request.getPhoneNumber());
        // step 1: validate request
        this.validateRegisterRequest(request);

        // step 2: check existed customer

        Customer customer = this.customerDomain.getCustomerByUserName(request.getPhoneNumber());
        BaseResponse response = new BaseResponse();

        return new BaseResponse();
    }


    public void validateRegisterRequest(RegisterRequest request)throws ApiException {
        if (StringUtils.isEmpty(request.getPhoneNumber())){
            log.info("validateRegisterRequest with username {} FAILD. phoneNumber is empty" , request.getPhoneNumber());
            throw new ApiException(ERROR.INVALID_DATA , "phoneNumber is empty" , HttpStatus.BAD_REQUEST);
        }

        if (ValidationUtils.isValidPhoneNumber(request.getPhoneNumber())){
            log.info("validateRegisterRequest with username {} FAILD. phoneNumber is invalid format" , request.getPhoneNumber());
            throw new ApiException(ERROR.INVALID_DATA , "phoneNumber is invalid format" , HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isEmpty(request.getPassword()) || StringUtils.isEmpty(request.getConfirmPassword())){
            log.info("validateRegisterRequest with username {} FAILD. password or confirm password is empty" , request.getPhoneNumber());
            throw new ApiException(ERROR.INVALID_DATA , "password or confirm password is empty" , HttpStatus.BAD_REQUEST);
        }

        if (!request.getConfirmPassword().equals(request.getPassword())){
            log.info("validateRegisterRequest with username {} FAILD. password or confirm password is not mapping" , request.getPhoneNumber());
            throw new ApiException(ERROR.INVALID_DATA , "password or confirm password is not mapping" , HttpStatus.BAD_REQUEST);
        }
    }



}
