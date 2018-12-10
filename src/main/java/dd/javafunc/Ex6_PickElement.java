package dd.javafunc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ex6_PickElement {
    final static List<String> orangeEurope = Arrays.asList("Belgia", "Francja", "Luksemburg", "Mołdawia", "Polska", "Rumunia", "Słowacja", "Hiszpania");

    //1 zdefiniuj imperatywnie metodę findOne(List<String> countries, String startingLetter)
    private final static String findOne(final List<String> countries, final String startingLetter) {
        String found = null;
        for (String name : countries) {
            if (name.startsWith(startingLetter)) {
                found = name;
                break;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        System.out.println(findOne(orangeEurope, "P"));

        //2 refaktor na stream, filter, findOne  .orElse

        Optional<String> found = orangeEurope.stream()
                .filter(name -> name.startsWith("P"))
                .findFirst();

        System.out.println(found.orElse("not found"));
    }
}
