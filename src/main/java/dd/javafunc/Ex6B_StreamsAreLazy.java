package dd.javafunc;

import java.util.Arrays;
import java.util.List;

public class Ex6B_StreamsAreLazy {
    final static List<String> orangeAfrica = Arrays.asList("Botswana", "Burkina Faso", "Kamerun", "Wybrzeże Kości Słoniowej", "Egipt", "Gwinea Bissau", "Gwinea", "Liberia", "Madagaskar", "Mauritius", "Mali", "Maroko", "Niger", "Republika Środkowoafrykańska", "Kongo", "Senegal", "Sierra Leone", "Tunezja");

    private static boolean containsSpace(String str) {
        System.out.println("looking for space in: " + str);
        return str.contains(" ");
    }

    private static int length(String str) {
        System.out.println("getting length for: " + str);
        return str.length();
    }

    public static void main(String[] args) {
        // #1
        // znajdź pierwszy kraj z przynajmniej jedną spacją w nazwie i długością przynajmniej 13 znaków
        // korzystając z filter, findFirst, get
        // #2
        // wypisz na ekran każde wykorzystanie filtra (np umieszczając System.out.println w Predicate

        String result = orangeAfrica.stream()
                .filter(country -> containsSpace(country))
                .filter(country -> length(country) > 12)
                .findFirst()
                .get();

        System.out.println(result);

    }
}
