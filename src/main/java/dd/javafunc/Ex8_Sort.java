package dd.javafunc;

import java.util.Arrays;
import java.util.List;

public class Ex8_Sort {
    final static List<String> orangeAfrica = Arrays.asList("Botswana", "Burkina Faso", "Kamerun", "Wybrzeże Kości Słoniowej", "Egipt", "Gwinea Bissau", "Gwinea", "Liberia", "Madagaskar", "Mauritius", "Mali", "Maroko", "Niger", "Republika Środkowoafrykańska", "Kongo", "Senegal", "Sierra Leone", "Tunezja");

    public static void main(String[] args) {

        //wylistujmy elementy posortowane alfabetycznie

        //0.0 imperatywnie zmieniamy stan (List.sort, anonimowy komparator)

        //0.1 imperatywnie zmieniając stan; z gotowym komparatorem naturalOrder

        //1.0 sorted, lambda

        //1.1 sorted, String::compareTo

        //1.2 sorted, Comparator.naturalOrder

        //2.0 odwracamy

    }
}
