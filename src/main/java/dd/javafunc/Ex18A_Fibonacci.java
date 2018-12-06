package dd.javafunc;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Ex18A_Fibonacci {

    //zaimplementuj Supplier ciągu Fibonacciego
    public static Supplier<Integer> fibonacci() {
        //...
        return null;
    }

    public static void main(String[] args) {
        Stream.generate(fibonacci())
                .limit(20)
                .forEach(System.out::println);
    }
}
