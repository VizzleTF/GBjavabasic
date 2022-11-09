package Homeworks.lesson1;

public class hw {
    static double hw3(int a, int b, int c, int d) {
        float f = d;
        return a * (b + c / f) ;
    }

    static boolean hw4(int a, int b){
        int sum = a + b;
        return sum > 10 && sum < 20;
    }

    static boolean hw8(int a) {
        return (a%4 == 0) && (a%100 != 0) || (a%400 == 0);
    }

    public static void main(String[] args) {

        double mathoperations = hw3(2,3,9,7);
        System.out.println("HW3 result: " + mathoperations);

        boolean bolshemenshe = hw4(7,5);
        System.out.println("HW4 result: " + bolshemenshe);

        boolean checkvisokos = hw8(1800);
        System.out.println("HW4 result: " + checkvisokos);
    }
}