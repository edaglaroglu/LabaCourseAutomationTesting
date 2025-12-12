package OdevSekiz.Department;

public enum RetirementAge {

    WOMAN(60),
    MAN(65);

    private int age;

    RetirementAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
