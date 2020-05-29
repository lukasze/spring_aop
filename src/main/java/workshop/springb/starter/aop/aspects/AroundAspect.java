package workshop.springb.starter.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static workshop.springb.starter.aop.Constans.AROUND;

@Aspect
@Component
@Profile(AROUND)
public class AroundAspect {

    static final String AROUND_BEFORE_MSG = "around before";
    static final String AROUND_AFTER_MSG = "around after";

    @Around("workshop.springb.starter.aop.pointcuts.AppPointcuts.methodsInServicePackage()")
    public void logAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println(AROUND_BEFORE_MSG);
        try {
            proceedingJoinPoint.proceed();
            System.out.println(AROUND_AFTER_MSG);
        } catch (Exception e) {
            System.out.println(AROUND_AFTER_MSG + " " + e.getClass().getSimpleName());
            throw e;
        }
    }
}