package workshop.springb.starter.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static workshop.springb.starter.aop.Constans.BEFORE;

@Aspect
@Component
@Profile(BEFORE)
public class BeforeAspect {

    @Before("workshop.springb.starter.aop.pointcuts.AppPointcuts.methodsInServicePackageAndSubpackages()")
    public void logAdvice() {

        System.out.println(BEFORE);

    }

}
