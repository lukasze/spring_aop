package workshop.springb.starter.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static workshop.springb.starter.aop.Constans.BEFORE;

/*
    TODO 5a zmień klasę w  aspect, działający tylko w profilu 'before'
 */
@Aspect
@Component
@Profile(BEFORE)
public class BeforeAspect {
    /*
       TODO 5b
       Advice: before z pointcut'em wskazującym na metody w klasie workshop.springb.starter.service i podpakietach

       Wypisz do konsoli profil
    */

    @Before("workshop.springb.starter.aop.pointcuts.AppPointcuts.methodsInServicePackageAndSubpackages()")
    public void logAdvice() {

        System.out.println(BEFORE);

    }

}
// TODO 5c utwórz test (klasa testowa już czeka) ツ
