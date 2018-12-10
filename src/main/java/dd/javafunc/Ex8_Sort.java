package dd.javafunc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex8_Sort {
    final static List<String> orangeAfrica = Arrays.asList("Botswana", "Burkina Faso", "Kamerun", "Wybrzeże Kości Słoniowej", "Egipt", "Gwinea Bissau", "Gwinea", "Liberia", "Madagaskar", "Mauritius", "Mali", "Maroko", "Niger", "Republika Środkowoafrykańska", "Kongo", "Senegal", "Sierra Leone", "Tunezja");

    public static void main(String[] args) {

        //wylistujmy elementy posortowane alfabetycznie

        //0.0 imperatywnie zmieniamy stan
        orangeAfrica.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(orangeAfrica);

        //0.1 imperatywnie nie zmieniając stanu; z gotowym komparatorem
        List<String> sorted = new ArrayList<>(orangeAfrica);
        sorted.sort(Comparator.naturalOrder());
        System.out.println(sorted);

        //1.0 sorted, lambda
        System.out.println(orangeAfrica.stream()
                .sorted((name1, name2) -> name1.compareTo(name2))
                .collect(Collectors.joining(",")));

        //1.1 sorted, String::compareTo
        System.out.println(orangeAfrica.stream()
                .sorted(String::compareTo)
                .collect(Collectors.joining(",")));

        //1.2 sorted, Comparator.naturalOrder
        System.out.println(orangeAfrica.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(",")));

        //2.0 odwracamy
        System.out.println(orangeAfrica.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(",")));


    }
}
