package Homeworks.lesson5;

public class Main {
    public static void main(String[] args){
        Cat Vasya = new Cat("Vasya");
        Cat Rocket = new Cat("Rocket", 250, 5);

        Dog Snejok = new Dog("Snejok");
        Dog Flash = new Dog("Flash", 1000, 0.3f, 15);

        Animal[] animals = {Vasya, Rocket, Snejok, Flash};

        showYourselfs(animals);
        checkrun(300, animals);
        checkjump(1, animals);
        checkswim(11, animals);
    }

    private static void showYourselfs(Animal[] a){
        for (Animal pos : a)
            pos.showInfo();
    }
    private static void checkrun(int check, Animal[] a) {
        System.out.println("\n" + "How can run " + check + "m:");
        for (Animal pos : a)
            System.out.println(pos.getName() + ": " + (pos.getRun() > check));
    }

    private static void checkjump(int check, Animal[] a) {
        System.out.println("\n" + "How can jump " + check + "m:");
        for (Animal pos : a)
            System.out.println(pos.getName() + ": " + (pos.getJump() > check));
    }

    private static void checkswim(int check, Animal[] a) {
        System.out.println("\n" + "How can swim " + check + "m:");
        for (Animal pos : a) {
            if (pos instanceof Dog)
                System.out.println(pos.getName() + ": " + (((Dog) pos).getSwim() > check));
            else
                System.out.println(pos.getName() + " is a cat. Cats not swim.");
        }
    }
}
