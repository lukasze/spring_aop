package workshop.springb.starter.aop.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class AppPointcuts {

    @Pointcut("execution(* workshop.springb.starter.service.*.*(..))")
    public void methodsInServicePackage() {
    }
}




