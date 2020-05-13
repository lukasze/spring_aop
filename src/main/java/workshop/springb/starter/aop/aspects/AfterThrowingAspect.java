package workshop.springb.starter.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static workshop.springb.starter.aop.Constans.AFTER_THROWING;

/*
    TODO 4a zmień klasę w  aspect, działający tylko w profilu 'after_throwing'
 */
@Aspect
@Component
@Profile(AFTER_THROWING)
public class AfterThrowingAspect {
    /*
       TODO 4b

       Advice: after throwing z pointcut'em wskazującym na metody w klasie GreetSubservice
         workshop.springb.starter.aop.anotations.@Loggable.

       Wypisz do konsoli profil i argumenty joinPoint
    */
    @AfterThrowing("workshop.springb.starter.aop.pointcuts.AppPointcuts.methodsInAClassGreetSubservice()")
    public void logAdvice(JoinPoint joinPoint) {

        System.out.println(AFTER_THROWING + " " + joinPoint.getArgs().length);

    }

}
// TODO 4c - utwórz test (klasa testowa już czeka) ツ
