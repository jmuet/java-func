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

    //zaimplementuj calcPrimeSqrts funkcyjnie, filter limit
    public static double calcPrimeSqrtsFunc(int from, int k) {
        //...
        return 0;
    }

    public static void main(String[] args) {
        //policzmy sumę kwadratów k liczb pierwszych zaczynając od from
        System.out.println(calcPrimeSqrts(7, 4));

        //1.0 refactor na funkcyjne (iterate, filter, limit, mapToDouble)

        //1.1 refactor na strumień liczb pierwszych (Stream.iterate wg custom metody nextPrimeAfter)
    }

}
