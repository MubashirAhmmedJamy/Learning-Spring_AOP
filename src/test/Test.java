package test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.EmpService;
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("test/AOP.xml");
        EmpService e = context.getBean("empservice", EmpService.class);
        System.out.println("1::");
        System.out.println(e.getAccountant().getName());
        System.out.println("2::");
        System.out.println(e.getAccountant().getName());
        System.out.println("3::");
        System.out.println(e.getManager().getScore());
        System.out.println("4::");
        e.getManager().setName("New Manager");
        System.out.println("5::");
        System.out.println(e.getManager().getName());
        
    }
}
