package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAdviceAspect {
    
    @Before("@annotation(aspect.Logger)")
    public void customeAdvice(JoinPoint join){
        System.out.println("Custom-Before: method = "+join.toString() + " | class = "+join.getTarget().getClass());
    }
    
    @Around("execution(* *Income(..))")
    public Object aroundAdvice(ProceedingJoinPoint join){
        Object income = null;
        try {
            System.out.println("Before: method = "+join.toString() + " | class = "+join.getTarget().getClass());
            income = join.proceed();
            System.out.println("After returning: method = "+join.toString() + " | class = "+join.getTarget().getClass());
        } catch (Throwable ex) {
            System.out.println("After throwing: exception = "+ ex.toString()+ " | method = "+join.toString() + " | class = "+join.getTarget().getClass());
        }
        System.out.println("After: method = "+join.toString() + " | class = "+join.getTarget().getClass());
        return income;
    }
}
