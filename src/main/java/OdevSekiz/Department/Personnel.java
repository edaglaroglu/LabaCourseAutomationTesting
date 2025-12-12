package OdevSekiz.Department;

public abstract class Personnel {

   protected int id;
   protected String name;
   protected String surname;
   protected int birthYear;
   protected String sex;

   protected static int counter = 1001;

    public Personnel(String name, String surname, int birthYear, String sex) {
        this.id = counter++;
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public abstract int calculateRemainingYears();

    @Override
    public String toString() {
        return "Personnel" + "\n" +
                "id=" + id + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", surname='" + surname + '\'' + "\n" +
                ", birthYear=" + birthYear + "\n" +
                ", sex='" + sex + '\'' + "\n"
                ;
    }

}


