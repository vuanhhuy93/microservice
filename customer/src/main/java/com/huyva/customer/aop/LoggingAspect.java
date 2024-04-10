package com.huyva.customer.aop;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);


    @Autowired
    protected HttpServletRequest httpServletRequest;


    @Pointcut("execution(* com.huyva.customer.controllers..*(..)))")
    protected void restControllers() {
    }


    @Around("(restControllers())")
    public Object logAspectController(ProceedingJoinPoint pjp) throws Throwable {

        Object output = null;
        output = pjp.proceed();


        return output;
    }


}
