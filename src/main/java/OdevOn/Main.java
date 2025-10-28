package OdevOn;

import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static int findFirstMatch(List<Integer> list, Predicate<Integer> condition) {

        return list.stream()
                .filter(condition)
                .findFirst()
                .orElse(-1);
    }

    public static void main(String[] args) {


        GenericValue<Integer> integerValue = new GenericValue<>();
        integerValue.setContent(10);
        GenericValue<String> stringValue = new GenericValue<>();
        stringValue.setContent("Bilinmeyen");
        GenericValue<Double> doubleValue = new GenericValue<>();
        doubleValue.setContent(10.5);
        GenericValue<Boolean> booleanValue = new GenericValue<>();
        booleanValue.setContent(true);

        integerValue.printContent();
        stringValue.printContent();
        doubleValue.printContent();
        booleanValue.printContent();

        //stream

        List<Integer> numbers = List.of(3, 10, 15, 22, 8, 30);
        Predicate<Integer> biggerThan10 = n -> n > 10;

       int result = findFirstMatch(numbers,biggerThan10);
        System.out.println(result);








    }
}
