package dd.javafunc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Ex6A_PickLongest {
    final static List<String> orangeAfrica = Arrays.asList("Botswana", "Burkina Faso", "Kamerun", "Wybrzeże Kości Słoniowej", "Egipt", "Gwinea Bissau", "Gwinea", "Liberia", "Madagaskar", "Mauritius", "Mali", "Maroko", "Niger", "Republika Środkowoafrykańska", "Kongo", "Senegal", "Sierra Leone", "Tunezja");

    public static void main(String[] args) {

        //znajdź najdłuższą nazwę

        //0.0 klasycznie imperatywnie
        int max = -1;
        String found = null;
        for(String country: orangeAfrica) {
            if (country.length() > max) {
                max = country.length();
                found = country;
            }
        }
        System.out.println(found);

        //1.0 funkcyjnie, max z lambdą Comparator
        orangeAfrica.stream()
                .max((o1, o2) -> o1.length() - o2.length())
                .ifPresent(System.out::println);

        //1.1 max Comparator.comparingInt
        orangeAfrica.stream()
                .max(Comparator.comparingInt(String::length))
                .ifPresent(System.out::println);

        //1.2 reduce z BinaryOperator
        orangeAfrica.stream()
                .reduce((s, s2) -> {return s.length() > s2.length() ? s : s2;})
                .ifPresent(System.out::println);

        //1.3 reduce z BinaryOperator
        orangeAfrica.stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparingInt(country -> country.length())))
                .ifPresent(System.out::println);

        //1.4 collect Collectors.reducing referencja na String.length
        orangeAfrica.stream()
                .collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingInt(String::length))))
                .ifPresent(System.out::println);

    }
}
