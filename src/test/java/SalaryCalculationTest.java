import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SalaryCalculationTest {

    @Test (dataProvider = "SalaryCalculationData")
    public void testCalculateSalary(int day, int dailyPay, int expectedSalary) {

        System.out.println("\n<----Testing calculate salary------>\n");

        int actualSalary = (day <= 20 ) ?
                OdevOnUc.SalaryCalculation.salaryCalculation(day, dailyPay) :
                OdevOnUc.SalaryCalculation.overtimePayCalculation(day, dailyPay);

                Assert.assertEquals(actualSalary, expectedSalary, "Salary Calculation Failed " + "day: " + day + " dailyPay: " + dailyPay );

        System.out.println("day: " + day + " dailyPay: " + dailyPay + " expectedSalary: " + expectedSalary);
        System.out.println("\n<--------Test finished...---------->\n");
    }

    @DataProvider(name = "SalaryCalculationData")
    public Object[][] SalaryDataProvider() {
        return new Object[][] {
                {19, 2000, 38000},
                // 21 -- 25 (1000TL)
                {21, 2000, (21*2000) + (1*1000)},
                {25, 2000, (25*2000) + (5*1000)},
                // 25 --- 31 (3000)
                {26, 2000, (26*2000) + (5*1000) + (1*3000)},
                // For 32nd day
                {32, 2000, 0}
                // There is a problem with this method. It does not cover cases where the number of days is greater than 31. Thank you TestNG :)
        };
    }
}
