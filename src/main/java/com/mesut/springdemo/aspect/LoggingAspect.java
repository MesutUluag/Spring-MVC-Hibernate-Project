package com.mesut.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    //create a logger
    private Logger mylogger= Logger.getLogger(getClass().getName());

    //pointcut declaration
    @Pointcut("execution(* com.mesut.springdemo.controller.*.*(..))")
    public void forControllerPackage(){ }

    @Pointcut("execution(* com.mesut.springdemo.service.*.*(..))")
    public void forServicePackage(){ }

    @Pointcut("execution(* com.mesut.springdemo.dao.*.*(..))")
    public void forDAOPackage(){ }

    @Pointcut("forControllerPackage()||forServicePackage()||forDAOPackage()")
    public void forAppFlow(){ }

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        String theMethod=joinPoint.getSignature().toShortString();
        mylogger.info("====>Before Calling Method "+ theMethod);

        //display method arguments
        Object[] args= joinPoint.getArgs();
        for(Object arg:args){
            mylogger.info("====>method arguments:  " + arg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()",
                    returning = "theResult")
    public void afterReturning(JoinPoint joinPoint, Object theResult){
        String theMethod=joinPoint.getSignature().toShortString();
        mylogger.info("====>AfterReturning Calling Method "+ theMethod);

        //display data returned
        mylogger.info("====> Result: " + theResult);

//        //display method arguments
//        Object[] args= joinPoint.getArgs();
//        for(Object arg:args){
//            mylogger.info("====>method arguments:  " + arg);
//        }
    }
}
