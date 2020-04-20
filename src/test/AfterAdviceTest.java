package test;

import model.Accountant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AfterAdviceTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("test/AOP.xml");
        Accountant a = context.getBean("accountant", Accountant.class);
        System.out.println("1::");
        a.getName();
        System.out.println("\n\n2::");
        a.setScore(2000);
        System.out.println("\n\n3::");
        a.getScore();
        
    }
}
