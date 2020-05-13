package workshop.springb.starter.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static workshop.springb.starter.aop.Constans.AFTER_THROWING;

@Aspect
@Component
@Profile(AFTER_THROWING)
public class AfterThrowingAspect {

    @AfterThrowing("workshop.springb.starter.aop.pointcuts.AppPointcuts.methodsInAClassGreetSubservice()")
    public void logAdvice(JoinPoint joinPoint) {

        System.out.println(AFTER_THROWING + " " + joinPoint.getArgs().length);

    }

}
