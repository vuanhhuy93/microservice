package com.huyva.customer.aop;

import com.huyva.customer.models.ApiException;
import com.huyva.customer.models.ERROR;
import com.huyva.customer.models.response.BaseResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandle {
    private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandle.class);

    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public ResponseEntity<BaseResponse> handleCustomizedException(ApiException e) {
        LOGGER.info("Exception {}", e.getMessage());
        HttpStatus httpStatus = e.getHttpStatus() == null ? HttpStatus.BAD_REQUEST : e.getHttpStatus();
        return new ResponseEntity<>(new BaseResponse(e.getCode(), e.getMessage()), httpStatus);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<BaseResponse> handleInternalException(Exception ex) {
        try {
            LOGGER.error("Exception ", ex);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new BaseResponse(ERROR.SYSTEM_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
