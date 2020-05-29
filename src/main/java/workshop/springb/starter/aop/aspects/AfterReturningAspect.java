package workshop.springb.starter.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static workshop.springb.starter.aop.Constans.AFTER_RETURNING;

@Component
@Profile(AFTER_RETURNING)
public class AfterReturningAspect {

    @AfterReturning("workshop.springb.starter.aop.pointcuts.AppPointcuts.methodsInClassesAnnotatedWithLoggable()")
    public void logAdvice(JoinPoint joinPoint) {

        System.out.println(AFTER_RETURNING + " " + joinPoint.getSignature());

    }

}
