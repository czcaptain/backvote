package org.example.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Aspect
public class LogsAspect {
    private final static Logger log = LoggerFactory.getLogger(LogsAspect.class);



    /**
     * 可重复使用的切点表达式
     */
    @Pointcut("@annotation(org.example.annotion.CountTime)")
    public void executeTiming(){}

    /**
     * 记录带有该注解的方法
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("executeTiming()")
    public Object logMethodTiming(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object returnValue = proceedingJoinPoint.proceed();
        long totalTime = System.currentTimeMillis() - startTime;
        log.info("程序执行时间 === > {totalTime}",totalTime);
        return returnValue;
    }
}
