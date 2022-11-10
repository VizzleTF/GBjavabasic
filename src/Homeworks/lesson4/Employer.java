package Homeworks.lesson4;

public class Employer {
    final String fio;
    int salary;
    final int yearOfBirth;
    final int uid;
    static int counter = 0;
    static int currentYear = 2022;

    Employer(String fio, int salary, int yearOfBirth) {
        this.fio = fio;
        this.salary = salary;
        this.yearOfBirth = yearOfBirth;
        this.uid = count();
    }

    void showInfo() {
        System.out.println("UID: " + uid + " this is " + fio + "\t Age: " + this.getAge() + "\t Salary: " + salary);
    }

    static int count() {
        counter++;
        return counter;
    }

    int getAge() {
        return currentYear - this.yearOfBirth;
    }

}
