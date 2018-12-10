package dd.javafunc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex7_Join {
    final static List<String> orangeAfrica = Arrays.asList("Botswana", "Burkina Faso", "Kamerun", "Wybrzeże Kości Słoniowej", "Egipt", "Gwinea Bissau", "Gwinea", "Liberia", "Madagaskar", "Mauritius", "Mali", "Maroko", "Niger", "Republika Środkowoafrykańska", "Kongo", "Senegal", "Sierra Leone", "Tunezja");

    public static void main(String[] args) {
        //wylistujmy elementy rozdzielając je przecinkiem

        //0.0 imperatywnie
        for (int i =0; i < orangeAfrica.size() - 1; i++) {
            System.out.print(orangeAfrica.get(i) + ", ");
        }
        System.out.println(orangeAfrica.get(orangeAfrica.size() - 1));

        //1.0 funkcyjnie z Collectors.joining
        String joined = orangeAfrica.stream()
                .collect(Collectors.joining(", "));

        System.out.println(joined);

    }
}
