package org.example.session09_b5.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Aspect
@Component
@Slf4j
public class SystemFailureMonitorAspect {
    @AfterThrowing(pointcut = "execution(* org.example.session09_b5.service.*.*(..))", throwing = "ex")
    public void monitorSystemFailure(Exception ex) {
        MDC.put("requestId", UUID.randomUUID().toString());
        log.error("Lỗi: {}", ex.getMessage(), ex);
        MDC.clear();
    }
}