package workshop.springb.starter.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static workshop.springb.starter.aop.Constans.AFTER;

/*
    TODO 2a zmień klasę w  aspect, działający tylko w profilu 'after'
 */
@Aspect
@Component
@Profile(AFTER)
public class AfterAspect {
    /*
        TODO 2b
        Advice: after, z pointcut'em wskazującym na metody, których nazwa zaczyna się na 'gr'

        Wypisz do konsoli profil i JoinPoint#getKind() after +

     */
    @Before("workshop.springb.starter.aop.pointcuts.AppPointcuts.methodsStartWithGr()")
    public void logAdvice(JoinPoint joinPoint) {

        System.out.println(AFTER + " " + joinPoint.getKind());

    }

}
// TODO 2c - utwórz test (klasa testowa już czeka) ツ
