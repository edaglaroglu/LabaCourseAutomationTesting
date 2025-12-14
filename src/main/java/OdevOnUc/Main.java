package OdevOnUc;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        int salary;
        int dailyPay = 2000;
        int day;

        day = random.nextInt(31);
        System.out.println("Working day: " + day);

        salary = SalaryCalculation.salaryCalculation(day, dailyPay);
        System.out.println("Calculated Salary: "+ salary + "TL");
    }
}
