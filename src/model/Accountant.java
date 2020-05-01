package model;

public class Accountant {
    private String name;
    private int score = 100;

    public int getScore() {
        System.out.println("getScore method throwing exceoption from accountant.");
        throw (new RuntimeException("This Exception was plotted"));  
//        return score;
    }

    public int setScore(int score) {
        this.score = score;
        System.out.println("setScore method returning from accountant");
        return 1000;
    }
    
    public String getName() {
        System.out.println("Printing from Accountant getName: "+name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
