package com.huyva.customer.services;

import com.huyva.base.models.ApiException;
import com.huyva.base.models.BaseResponse;
import com.huyva.base.models.ERROR;
import com.huyva.base.utils.Constant;
import com.huyva.base.utils.HashUtils;
import com.huyva.base.utils.JwtUtils;
import com.huyva.customer.database.entities.Customer;
import com.huyva.customer.domains.CustomerDomain;
import com.huyva.customer.models.request.login.LoginRequest;
import com.huyva.customer.models.response.login.LoginResponse;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@Log4j2
public class LoginService {
    private CustomerDomain customerDomain;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public LoginService(CustomerDomain customerDomain){
        this.customerDomain = customerDomain;
    }


    public BaseResponse<LoginResponse> login(LoginRequest request) throws ApiException{

        log.info("login request from account {} " , request.getUserName());

        // step 1: validate

        if (StringUtils.isBlank(request.getUserName())){
            log.info("login FAIL - username is blank");
            throw new ApiException(ERROR.INVALID_DATA , HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(request.getPassword())){
            log.info("login FAIL - password is blank");
            throw new ApiException(ERROR.INVALID_DATA , HttpStatus.BAD_REQUEST);
        }

        String phoneNumber = com.huyva.base.utils.StringUtils.formatPhoneNumber(request.getUserName());

        Customer customer = customerDomain.getCustomerByUserName(phoneNumber);

        if (customer == null){
            log.info("login FAIL - user not found ");
            throw new ApiException(ERROR.USER_NOT_MAP , HttpStatus.BAD_REQUEST);
        }

        if (customer.getStatus() == Constant.USER_STATUS.DISABLE){
            log.info("login FAIL - user status invalid ");
            throw new ApiException(ERROR.USER_BLOCKED, HttpStatus.BAD_REQUEST);
        }

        LocalDateTime now = LocalDateTime.now();

        if (customer.getBlockTotime() != null && customer.getBlockTotime().isAfter(now)){
            log.info("user {} is block to {}" , phoneNumber, customer.getBlockTotime());

            throw new ApiException(ERROR.USER_LOCKED, HttpStatus.BAD_REQUEST);
        }

        if (!bCryptPasswordEncoder.matches(request.getPassword(), customer.getPassword())){
            log.info("user {} password invalid" , phoneNumber);
            throw new ApiException(ERROR.LOGIN_FAIL, HttpStatus.BAD_REQUEST);
        }
        Map<String, Object> data = new HashMap<>();

        String customerId = HashUtils.hashId(customer.getId());

        data.put("id" , customerId);
        data.put("userName" , customer.getUsername());

        String jwt = JwtUtils.buildJWTLogin(data);
        log.info("login request from account {} SUCCESS" , request.getUserName());

        BaseResponse<LoginResponse> response = new BaseResponse<>();

        LoginResponse dataResponse = new LoginResponse();
        dataResponse.setToken(jwt);

        response.setData(dataResponse);
        return response;
    }
}
