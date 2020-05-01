package model;

import aspect.Logger;

public class ShopKeeper {
    private String name;
    private int income = 200;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIncome() {
        System.out.println("getIncome returning");
        return income;
    }
    
    @Logger
    public void setIncome(int income) {
        this.income = income;
        System.out.println("setIncome throwing");
//        throw (new RuntimeException("This exception is plotted and thrown from setIncome"));
    }
}