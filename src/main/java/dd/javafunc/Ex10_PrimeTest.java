package dd.javafunc;

public class Ex10_PrimeTest {

    public static boolean isPrime(int number) {
        if (number < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0)
                return false;
        return true;
    }

    //zaimplementuj isPrimeFunc używając IntStream.range i noneMatch
    public static boolean isPrimeFunc(int number) {
        //...
        return false;
    }

    public static void main(String[] args) {
        //0.0 zbierzmy do Listy liczby pierwsze do 100 - imperatywnie

        //1.0 zbierzmy do Listy liczby pierwsze do 100, korzystając z IntStream.range

    }

}
