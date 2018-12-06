package dd.javafunc;

import java.util.Arrays;
import java.util.List;

public class Ex6A_PickLongest {
    final static List<String> orangeAfrica = Arrays.asList("Botswana", "Burkina Faso", "Kamerun", "Wybrzeże Kości Słoniowej", "Egipt", "Gwinea Bissau", "Gwinea", "Liberia", "Madagaskar", "Mauritius", "Mali", "Maroko", "Niger", "Republika Środkowoafrykańska", "Kongo", "Senegal", "Sierra Leone", "Tunezja");

    public static void main(String[] args) {

        //znajdź najdłuższą nazwę kraju

        //0.0 klasycznie imperatywnie

        //1.0 funkcyjnie, max z lambdą Comparator

        //1.1 max Comparator.comparingInt

        //1.2 reduce z BinaryOperator

        //1.3 reduce z BinaryOperator

        //1.4 collect Collectors.reducing referencja na String.length

    }
}
