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
    @AfterThrowing(pointcut = "execution(* org.example.session09_b5.Service.*.*(..))", throwing = "ex")
    public void monitorSystemFailure(Exception ex) {
        try {
            String requestId = UUID.randomUUID().toString();
            MDC.put("requestId", requestId);
            log.error("lỗi: {}", ex.getMessage(), ex);
        } catch (Exception e) {
            log.error("Failed to log system failure", e);
        }finally {
            MDC.clear();
        }
    }
}
