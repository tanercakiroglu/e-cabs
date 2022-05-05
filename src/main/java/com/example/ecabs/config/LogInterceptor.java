package com.example.ecabs.config;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

@Aspect
@Component
@Log4j2
public class LogInterceptor {


    @Around(value = "@within(loggable) || @annotation(loggable)", argNames = "joinPoint,loggable")
    public Object performanceLog(ProceedingJoinPoint joinPoint, Loggable loggable) throws Throwable {
        final var stopWatch = new StopWatch();
        stopWatch.start();

        final Object ret = joinPoint.proceed();

        stopWatch.stop();

        final StringBuilder logMessage = new StringBuilder();
        if (loggable == null) {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            loggable = method.getAnnotation(Loggable.class);
        }
        logMessage.append(loggable.value());
        logMessage.append(joinPoint.getSignature().getName());
        logMessage.append("(");
        // append args
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logMessage.append(arg).append(",");
        }
        if (args.length > 0) {
            logMessage.deleteCharAt(logMessage.length() - 1);
        }

        logMessage.append(")");
        logMessage.append(" execution time: ");
        logMessage.append(stopWatch.getTotalTimeMillis());
        logMessage.append(" ms");
        if (log.isInfoEnabled()) {
            log.info(logMessage.toString());
        }
        return ret;
    }
}
