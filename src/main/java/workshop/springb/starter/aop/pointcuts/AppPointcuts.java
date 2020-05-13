package workshop.springb.starter.aop.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class AppPointcuts {

    /*
        TODO 4
        ----------------------------------------------------------------------------------------------------------------
        Pointcut wskazuje, gdzie wywołać extra logikę (gdzie są joitpoint'y, do których należy zastosować dvice).
        Spring AOP - dotyczy tylko publicznych metod. Jeśli to nie wystarcza, możemy zastosować AspectJ.

        Podsumowując w Spring AOP pointuct mówi Spring'owi przed / po / przedd-i-po której publicznej metody wywołać
        ekstra logikę z advice. \( ﾟヮﾟ)/

        Dla specyfikacji jointpoimt (w Spring AOP tylko publiczne metody) używamy wyrażenie pointcut:

        "execution(* workshop.springb.starter.service.*.*(..))"

        Wyrażenie ma designator 'execution' który oznacza metody. Mamy więcej desygnatorów, które oznaczają np.
        -metody w klasie danego typu,
        -metody w klasie oznaczonej konkretną adnotacją,
        -metody oznaczone konkretną adnotacją
        -metody przyjmujące String
        etc.

        Wyrażneie może być bezpośrednio użyte z advice, ale dobrą praktyką jest używanie pustych metod oznaczonych
        @Pointcut


        Zamiast:

        @Around(("execution(* workshop.springb.starter.service..*.*(..))")

        używamy

        @Around(methodsInPackageAndSubpackages())
        public public void logAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {//some logic}

        z

        wyrażeniem i metodą:
        @Pointcut("execution(* workshop.springb.starter.service..*.*(..))")
        public void methodsInPackageAndSubpackages() {}

        Użycie metody pozwala na czytelniejsze użycie i reużywanie pointcut, szczególnie gdy chcemy łączyć pointcut'y,
        używając operatorów &&, ||, ! :

        @Around(methodsInServiceAndSubpackages() ! methodsWithAnnotationLoggable())
        public void logAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {//some logic}

        Przejdźmy do następnego kroku.
        ----------------------------------------------------------------------------------------------------------------
                                                      \
                                                       \
                                                     |\/\/\/|
                                                     |      |
                                                     |      |
                                                     | (o)(o)
                                                     C      _)
                                                      | ,___|
                                                      |   /
                                                     /____\
                                                    /      \
     */

    @Pointcut("execution(* workshop.springb.starter.service.*.*(..))")
    public void methodsInServicePackage() {
    }
}




