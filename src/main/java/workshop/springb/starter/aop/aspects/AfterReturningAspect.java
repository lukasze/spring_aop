package workshop.springb.starter.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static workshop.springb.starter.aop.Constans.AFTER_RETURNING;

/*
    TODO 3a zmień klasę w  aspect, działający tylko w profilu 'after_returning'
 */
@Aspect
@Component
@Profile(AFTER_RETURNING)
public class AfterReturningAspect {
    /*
         TODO 3b
         Advice: after returning z pointcut'em wskazującym na metody w klasach z adnotacją
         workshop.springb.starter.aop.anotations.@Loggable.

          Wypisz do konsoli profil i typ obiektu (target, którego metoda będzie miała ten aspekt)
    */
    @AfterReturning("workshop.springb.starter.aop.pointcuts.AppPointcuts.methodsInClassesAnnotatedWithLoggable()")
    public void logAdvice(JoinPoint joinPoint) {

        System.out.println(AFTER_RETURNING + " " + joinPoint.getTarget().getClass().getSimpleName());

    }

}

// TODO 3c - utwórz test (klasa testowa już czeka) ツ
