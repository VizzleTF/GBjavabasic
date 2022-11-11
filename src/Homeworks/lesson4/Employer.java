package Homeworks.lesson4;

public class Employer {
    private final String fio;
    private int salary;
    private final int yearOfBirth;
    private final int uid;
    private static int counter = 0;
    private final int currentYear = 2022;

    Employer(String fio, int salary, int yearOfBirth) {
        this.fio = fio;
        this.salary = salary;
        this.yearOfBirth = yearOfBirth;
        this.uid = counter++;
    }

    void showInfo() { System.out.println("UID: " + uid + " this is " + fio + "\t Age: " + this.getAge() + "\t Salary: " + salary); }

    int getAge() { return currentYear - this.yearOfBirth; }

    int getSalary() { return this.salary; }

    void setSalary(int newSalary) { this.salary = newSalary; }

}
