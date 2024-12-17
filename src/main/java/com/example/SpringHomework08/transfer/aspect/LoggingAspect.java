package com.example.SpringHomework08.transfer.aspect;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Log
public class LoggingAspect {

    @Around("@annotation(com.example.SpringHomework08.transfer.aspect.TrackAction)")
    @Order(1)
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();
        System.out.println("Был вызван метод: "
                + methodName
                + "; параметры "
                + Arrays.asList(arguments));

        Object returnedByMethod = joinPoint.proceed();;
        System.out.println("Обработка метода завершена.");
        return returnedByMethod;
    }


    @Around("execution(* com.example.SpringHomework08.transfer.repository.*.*(..))")
    @Order(2)
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() -start;
        System.out.println("Время выполнения метода: "
                + joinPoint.getSignature().getName()
                + " - "+elapsedTime+" миллисекунд");
        return result;
    }
}
