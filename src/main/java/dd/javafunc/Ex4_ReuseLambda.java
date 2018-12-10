package dd.javafunc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Ex4_ReuseLambda {
    final static List<String> orangeEurope = Arrays.asList("Belgia", "Francja", "Luksemburg", "Mołdawia", "Polska", "Rumunia", "Słowacja", "Hiszpania");
    final static List<String> orangeAfrica = Arrays.asList("Botswana", "Burkina Faso", "Kamerun", "Wybrzeże Kości Słoniowej", "Egipt", "Gwinea Bissau", "Gwinea", "Liberia", "Madagaskar", "Mauritius", "Mali", "Maroko", "Niger", "Republika Środkowoafrykańska", "Kongo", "Senegal", "Sierra Leone", "Tunezja");
    final static List<String> orangeMiddleEast = Arrays.asList("Irak", "Jordania");

    public static void main(String[] args) {
        orangeEurope.stream()
            .filter(name -> name.endsWith("ia"))
            .forEach(System.out::println);

        orangeAfrica.stream()
                .filter(name -> name.endsWith("ia"))
                .forEach(System.out::println);

        orangeMiddleEast.stream()
                .filter(name -> name.endsWith("ia"))
                .forEach(System.out::println);

        //------------------------------------
        //1 wyciągnij wspólną lambdę (filter)
        //2 refaktor lamby by przyjmowała argument

        final Function<String, Predicate<String>> endsWith = chars -> name -> name.endsWith(chars);

        orangeEurope.stream()
                .filter(endsWith.apply("ia"))
                .forEach(System.out::println);

        orangeAfrica.stream()
                .filter(endsWith.apply("ia"))
                .forEach(System.out::println);

        orangeMiddleEast.stream()
                .filter(endsWith.apply("ia"))
                .forEach(System.out::println);

    }
}
