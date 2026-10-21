package org.example.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    @Before("execution(void org.example.service.UserService.logIn())")
    public void loggingAdvice(){
        System.out.println("Before login is executed");
    }

    @After("execution(void org.example.service.UserService.logIn())")
    public void afterLoggingAdvice(){
        System.out.println("After login is executed");
    }
}
