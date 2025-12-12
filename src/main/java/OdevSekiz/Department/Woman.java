package OdevSekiz.Department;

public class Woman extends Personnel {


    int currentYear = java.time.LocalDate.now().getYear();

    public Woman(String name, String surname, int birthYear) {
        super(name, surname, birthYear, "F");
    }


    //calculate remaining retirement year
    @Override
    public int calculateRemainingYears() {

       int  remainingYear = RetirementAge.WOMAN.getAge() - (currentYear - getBirthYear());
      // System.out.println("Remaining Retirement Year for " + getName() + " " + getSurname() + " = "  + remainingYear);

       return Math.max(0, remainingYear);
    }

}
