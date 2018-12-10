package dd.javafunc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex10_PrimeTest {

    public static boolean isPrime(int number) {
        if (number < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0)
                return false;
        return true;
    }

    public static boolean isPrimeFunc(int number) {
        return number > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
    }

    public static void main(String[] args) {
        //0.0 zbierzmy do Listy liczby pierwsze do 100 - imperatywnie
        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i <= 100; i++)
            if (isPrime(i))
                primes.add(i);

        System.out.println(primes);

        //1.0 zbierzmy do Listy liczby pierwsze do 100, korzystając z IntStream
        List<Integer> collectedPrimes = IntStream.rangeClosed(1, 100)
                .filter(Ex10_PrimeTest::isPrimeFunc)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(collectedPrimes);

        //1.1 zbierzmy do Listy pierwsze do 100, korzystając z IntStream oraz funkcyjnego testu na liczbę pierwszą (noneMatch)
        List<Integer> collectedPrimes2 = IntStream.rangeClosed(1, 100)
                .filter(Ex10_PrimeTest::isPrime)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(collectedPrimes2);
    }

}
