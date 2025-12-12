package OdevSekiz.Department;

public class Man extends Personnel{

    int currentYear = java.time.LocalDate.now().getYear();

    public Man(String name, String surname, int birthYear) {
        super(name, surname, birthYear, "M");
    }


    @Override
    //calculate retirement year
    public int calculateRemainingYears() {

        int  remainingYear = RetirementAge.MAN.getAge() - (currentYear - getBirthYear());
        //System.out.println("Remaining Retirement Year for " + getName() + " " + getSurname() + " = "  + remainingYear);

       return Math.max(remainingYear,0);
    }
}