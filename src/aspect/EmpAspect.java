package aspect;

import model.Accountant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmpAspect {
        
    
    @Before("allGetters() && allModelMethods()")
    public void one(JoinPoint join) {
        System.out.println("Before - Advice one all-Getter-ModelMethods: method = " + join.toString()+" | class = "+join.getTarget().getClass());
        
        if((join.getTarget().getClass()).toString().equals("class model.Accountant")){
            Accountant acc = (Accountant) join.getTarget();
            System.out.println("EmpAspect doing it's job:");
            System.out.println("Printing from all-Getter-ModelMethods: " + acc.getName());
            acc.setName("Hulululu accountant");
            //Proxied object can change the original object. This is not a copy only.
            System.out.println("New accountant name has been set.");
            System.out.println("EmpAspect finished it's job");
        }
    }
    
    @Before("allGetters()")
    public void two(JoinPoint join){
        System.out.println("Before - Advice two all-Getters: method = "+join.toString()+" | class = "+join.getTarget().getClass());
    }
    
    @Before("args(name)")
    public void three(JoinPoint join, String name){ //Joinpoint must always be the first parameter
        System.out.println("Before - Advice three all methods with argument: string = "+name+" | method = "+join.toString()+" | class = "+join.getTarget().getClass());
    }
    
    @Before("allModelMethods()")
    public void four(JoinPoint join) {
        System.out.println("Before - Advice four all-ModelMethods: method = " + join.toString() + " | class = " + join.getTarget().getClass());
    }
   
    @Pointcut("execution(* model..*.*(..))")
    public void allModelMethods(){}
    
    @Pointcut("execution(* get*(..))")
    public void allGetters(){} 
}
