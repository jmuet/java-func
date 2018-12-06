package dd.javafunc;

import java.util.Arrays;
import java.util.List;

public class Ex6_PickElement {
    final static List<String> orangeEurope = Arrays.asList("Belgia", "Francja", "Luksemburg", "Mołdawia", "Polska", "Rumunia", "Słowacja", "Hiszpania");

    //1 zdefiniuj imperatywnie metodę findOne
    private final static String findOne(final List<String> countries, final String startingLetter) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(findOne(orangeEurope, "P"));

        //2 znajdź element z użyciem stream, filter, findFirst

    }
}
