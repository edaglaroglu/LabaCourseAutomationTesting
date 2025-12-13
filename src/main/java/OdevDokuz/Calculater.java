package OdevDokuz;

public class Calculater {

    private int number;

    public Calculater(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public int sum(int a, int b) {
        System.out.println(a+b);
        return a + b;

    }

    public int divide(int a, int b) {

        if (b == 0) {
            throw new DivisionByZeroException("Sıfıra bölme işlemi hatası");
        }
        System.out.println(a/b);
        return a / b;
    }

}
