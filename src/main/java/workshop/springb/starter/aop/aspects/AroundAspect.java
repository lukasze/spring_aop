package workshop.springb.starter.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static workshop.springb.starter.aop.Constans.AROUND;


/*
    TODO 2 @Aspect oznacza klasę, w której będzeimy definiowali logikę poboczną - nie związaną  z domeną,
    ale ważną dla aplikacji - bezpieczeństwo, logowanie itp.

    W naszym przypadku będziemy  wypisywali do konsoli jakiś tekst ツ
 */
@Aspect
@Component
@Profile(AROUND)
public class AroundAspect {
    static final String AROUND_BEFORE_MSG = "around before";
    static final String AROUND_AFTER_MSG = "around after";

    /*
            TODO 3 @Around, @Before, @After, @AfterReturning, @AfterThrowing
     -----------------------------------------------------------------------------------------------------------------------

            Poniżższe adnotacje oznaczają Advice - metody, z funkcjonalnościami, które chcemy wywoływać razem z logiką domeny.

            @Around advice: możliwość wywołania dodatkowej logiki przed i po metodzie

            @Before and @After: jak wskazuje nazwa adnotacji

            @AfterReturning: po metodzie, jeśli nie został rzucony wyjątek

            @AfterThrowing: po metodzie, jeśli rzucono wyjątek

            Zauważ w poniższym przykładzie logAdvice przyjmuje parametr ProceedingJoinPoint - proceedingJoinPoint.proceed();
            to wywołanie metody, do której chcemy dodać extra logikę.
     -----------------------------------------------------------------------------------------------------------------------

     */
    @Around("workshop.springb.starter.aop.pointcuts.AppPointcuts.methodsInServicePackage()")
    public Object logAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        /*
            TODO 5 @Arround advice daje najwięcej możliwości, jako jedyna przyjmuje ProceedingJoinPoint

            To wszystko, mamy już gotowy test, który możemy uruchomić.  \( ﾟヮﾟ)/
            Przejdźmy do TODO6
         */
        Object o;
        System.out.println(AROUND_BEFORE_MSG);
        o = proceedingJoinPoint.proceed();
        System.out.println(AROUND_AFTER_MSG);
        return o;
    }
}