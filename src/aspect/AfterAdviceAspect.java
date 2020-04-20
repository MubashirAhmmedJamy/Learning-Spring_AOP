package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAdviceAspect {
    
    @After("execution(* getName())")
    public void afterAdvice(JoinPoint join){
        System.out.println("After - Advice one all getName: method = "+join.toString() +" | class = "+join.getTarget().getClass());
    }
    
    @AfterThrowing(pointcut = "execution(* *Score()) && execution(* get*())", throwing = "e")
    public void afterThrowingAdvice(JoinPoint join, Exception e) {
        System.out.println("After Throwing- Advice one all getScore: method = " + join.toString() + " | class = " + join.getTarget().getClass()+" | exception = " +e.toString());
    }
    
    @AfterReturning(pointcut = "execution(* *Score(..)) && execution(* set*(..))", returning = "x")
    public void afterReturningAdvice(JoinPoint join, int x) {
        System.out.println("After - Returning Advice one all setScore: method = " + join.toString() + " | class = " + join.getTarget().getClass() + " | returned value: "+x);
    }
    
    @After("execution(* setScore(..))")
    public void after_setScoreAdvice(JoinPoint join){
        System.out.println("After - setScore : method = "+join.toString() +" | class = "+join.getTarget().getClass());
    }
    @After("execution(* getScore(..))")
    public void after_getScoreAdvice(JoinPoint join){
        System.out.println("After - getScore : method = "+join.toString() +" | class = "+join.getTarget().getClass());
    }
}
