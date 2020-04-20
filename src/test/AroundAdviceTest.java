package test;

import model.ShopKeeper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AroundAdviceTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("test/AOP.xml");
        ShopKeeper shop = context.getBean("shopKeeper", ShopKeeper.class);
        System.out.println("1::");
        System.out.println("Calling setIncome");
        shop.setIncome(200000);
        System.out.println("2::");
        System.out.println("Main output: "+shop.getIncome()+" | done");
    }
}
