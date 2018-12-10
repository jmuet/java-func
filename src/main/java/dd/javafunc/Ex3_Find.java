package dd.javafunc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex3_Find {
    final static List<String> orangeEurope = Arrays.asList("Belgia", "Francja", "Luksemburg", "Mołdawia", "Polska", "Rumunia", "Słowacja", "Hiszpania");

    public static void main(String[] args) {
        //zbierzmy kraje które kończą się na "ia"
        //0.0 klasycznie imperatywnie
        List<String> endsWithIA = new ArrayList<>();

        for (String country : orangeEurope) {
            if (country.endsWith("ia"))
                endsWithIA.add(country);
        }

        endsWithIA.forEach(System.out::println);

        //1.0 funkcyjnie z filter
        endsWithIA = orangeEurope.stream()
                .filter(name -> name.endsWith("ia"))
                .collect(Collectors.toList());

        endsWithIA.forEach(System.out::println);

    }
}
