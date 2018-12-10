package dd.javafunc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex2_Transform {
    final static List<String> orangeEurope = Arrays.asList("Belgia", "Francja", "Luksemburg", "Mołdawia", "Polska", "Rumunia", "Słowacja", "Hiszpania");

    public static void main(String[] args) {
        //zmieńmy wszystkie nazwy na uppercase
        //0.0 klasycznie (tworzymy listę i dodajemy elementy)
        List<String> uppercases = new ArrayList<>();

        for (String country : orangeEurope) {
            uppercases.add(country.toUpperCase());
        }

        uppercases.forEach(System.out::println);

        //1.0 funkcyjnie map
        uppercases = orangeEurope.stream()
                .map(country -> country.toUpperCase())
                .collect(Collectors.toList());

        uppercases.forEach(System.out::println);

        //1.1 modyfikacja oryginalnej kolekcji przez List.replaceAll
        orangeEurope.replaceAll(country -> country.toUpperCase());

    }
}
