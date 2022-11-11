package Homeworks.lesson5;

public class Animal {
    private String name;
    private int run;
    private float jump;

    Animal(String name, int run, float jump) {
        this.name = name;
        this.run = run;
        this.jump = jump;
    }

    String getName(){ return this.name; }

    int getRun(){ return this.run; }

    float getJump(){ return this.jump; }

    void showInfo(){ System.out.println(name + " can run " + run + "m and jump " + jump + "m"); }
}
