package dd.javafunc;

import java.util.stream.Stream;

public class Ex11_PrimeSqrt {

    public static double calcPrimeSqrts(int from, int k) {
        double result = 0;
        int index = from;
        int count = 0;

        while (count < k) {
            if(Ex10_PrimeTest.isPrime(index)) {
                result += Math.sqrt(index);
                count++;
            }
            index++;
        }

        return result;
    }

    //----------------------
    public static double calcPrimeSqrtsFunc(int from, int k) {
        return Stream.iterate(from, e -> e + 1)
                .filter(Ex10_PrimeTest::isPrime)
                .limit(k)
                .mapToDouble(Math::sqrt)
                .sum();
    }

    private static int primeAfter(final int number) {
        if (Ex10_PrimeTest.isPrime(number + 1))
            return number + 1;
        return primeAfter(number + 1);
    }

    public static double calcPrimeSqrtsWithPrimeStream(int from, int k) {
        return Stream.iterate(primeAfter(from - 1), Ex11_PrimeSqrt::primeAfter)
                .limit(k)
                .mapToDouble(Math::sqrt)
                .sum();
    }

    public static void main(String[] args) {
        //policzmy sumę kwadratów k liczb pierwszych zaczynając od from
        System.out.println(calcPrimeSqrts(7, 4));

        //1.0 refactor na funkcyjne (iterate, filter, limit, mapToDouble)
        System.out.println(calcPrimeSqrtsFunc(7, 4));

        //1.1 refactor na strumień liczb pierwszych (iteracja wg custom metody nextPrimeAfter)
        System.out.println(calcPrimeSqrtsWithPrimeStream(7, 4));
    }

}
