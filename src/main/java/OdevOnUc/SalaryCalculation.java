package OdevOnUc;

import java.util.Random;

public class SalaryCalculation {

    // if day is less than or equal 20
    public static int salaryCalculation(int day, int dailyPay) {

        return day * dailyPay;

    }

    // if day is greater than 20
    public static int overtimePayCalculation(int day, int dailyPay) {

        if (day <= 25) {
            // day = 21 - 25
            return (day * dailyPay) + (day - 20) * (1000);

        } else {
            // day = 26 - 31
            return (day * dailyPay) + (5 * 1000) + (day - 25) * (3000);
        }

    }

    public static void main(String[] args) {

        Random random = new Random();
        int salary;
        int dailyPay = 2000;
        int day;

        //day = random.nextInt(31);
        day = 26;
        System.out.println("Working day: " + day);

        salary = (day <= 20) ? salaryCalculation(day, dailyPay) : overtimePayCalculation(day, dailyPay);
        System.out.println("Calculated Salary: "+ salary + "TL");

    }
}
