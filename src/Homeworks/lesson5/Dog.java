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
    void showInfo(){ System.out.println(getName() + " can run " + getRun() + "m, jump " + getJump() + "m and swim " + swim +"m"); }

    float getSwim(){ return this.swim; }
}
