package dd.javafunc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Ex18_Supplier {

    public static void main(String[] args) {
        Supplier<Integer> x = supplier1();
        Supplier<Integer> y = supplier2();

        IntStream.range(0, 4).forEach(i -> System.out.print(x.get()));
        System.out.println();
        IntStream.range(0, 4).forEach(i -> System.out.print(y.get()));
        System.out.println();
    }

    private static Supplier<Integer> supplier1() {
        return () -> {
            int x = 0;
            return x++;
        };
    }

    private static Supplier<Integer> supplier2() {
        AtomicInteger x = new AtomicInteger(0);
        return () -> x.incrementAndGet();
    }

}
