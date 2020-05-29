package workshop.springb.starter.aop.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class AppPointcuts {


    @Pointcut("execution(* gr*(..))")
    public void methodsStartWithGr() {
    }


    @Pointcut("execution(* workshop.springb.starter.service.*.*(..))")
    public void methodsInServicePackage() {
    }


    @Pointcut("execution(* workshop.springb.starter.aop.pointcuts..*.*(..))")
    public void methodsInServicePackageAndSubpackages() {
    }

    @Pointcut("args(boolean)")
    public void methodsThatTakeBoolean() {
    }

    @Pointcut("@annotation(workshop.springb.starter.aop.anotations.Loggable)")
    public void methodsWithAnnotationLoggable() {
    }


    @Pointcut("@within(workshop.springb.starter.aop.anotations.Loggable)")
    public void methodsInClassesAnnotatedWithLoggable() {
    }

    @Pointcut("within(workshop.springb.starter.aop.Constans)")
    public void methodsInAClassGreetSubservice() {
    }

    @Pointcut("execution(* workshop.springb.starter.service.subservice.GreetSubservice.*(..))")
    public void methodsInAClassGreetSubservice2() {
    }
}




