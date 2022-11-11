package Homeworks.lesson5;

public class Dog extends Animal{
    private int swim;

    Dog(String name) {
        super(name, 500, 0.5f);
        this.swim = 10;
    }

    Dog(String name, int run, float jump, int swim) {
        super(name, run, jump);
        this.swim = swim;
    }

    @Override
    void showInfo(){ System.out.println(name + " can run " + run + "m, jump " + jump + "m and swim " + swim +"m"); }

    float getSwim(){ return this.swim; }
}
