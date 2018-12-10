package dd.javafunc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex2A_TransformToDifferentType {
    final static List<String> orangeEurope = Arrays.asList("Belgia", "Francja", "Luksemburg", "Mołdawia", "Polska", "Rumunia", "Słowacja", "Hiszpania");

    public static void main(String[] args) {
        //zbierzmy listę długości nazw krajów
        //0.0 klasycznie (tworzymy listę i dodajemy elementy)
        List<Integer> lengths = new ArrayList<>();

        for (String country : orangeEurope) {
            lengths.add(country.length());
        }

        lengths.forEach(System.out::println);

        //1.0 funkcyjnie map
        lengths = orangeEurope.stream()
                .map(country -> country.length())
                .collect(Collectors.toList());

        lengths.forEach(System.out::println);

    }
}
