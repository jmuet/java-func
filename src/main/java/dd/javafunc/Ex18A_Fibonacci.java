package dd.javafunc;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Ex18A_Fibonacci {

    //zaimplementuj Supplier ciągu Fibonacciego
    public static Supplier<Integer> fibonacci() {
        int[] seq = {0, 1};
        return () -> {
            int result = seq[1];
            int nextFib = seq[0] + seq[1];
            seq[0] = seq[1];
            seq[1] = nextFib;
            return result;
        };
    }

    public static void main(String[] args) {
        Stream.generate(fibonacci())
                .limit(20)
                .forEach(System.out::println);
    }
}
