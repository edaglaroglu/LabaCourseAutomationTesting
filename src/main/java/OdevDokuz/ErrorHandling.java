package OdevDokuz;

public class ErrorHandling {

    public static void main(String[] args) {

        int number = 8;

        Calculater calculater = new Calculater(number);

        calculater.divide(number,2);
        calculater.sum(number,0);
        calculater.divide(number,0);



    }
}
