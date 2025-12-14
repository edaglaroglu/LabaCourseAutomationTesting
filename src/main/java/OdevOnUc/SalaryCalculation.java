package OdevOnUc;

import java.util.Random;

public class SalaryCalculation {


    public static int salaryCalculation(int day, int dailyPay) {

        int salary =
                (day <= 20)
                        ? dailyPay * day
                        : (day <= 25) ? (day * dailyPay) + (day - 20) * 1000 : (day * dailyPay) + (5 * 1000) + (day - 25) * 3000;

        return salary;

    }

}
