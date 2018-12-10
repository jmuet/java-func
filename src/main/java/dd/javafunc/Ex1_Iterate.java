package dd.javafunc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Ex1_Iterate {
    final static List<String> orangeEurope = Arrays.asList("Belgia", "Francja", "Luksemburg", "Mołdawia", "Polska", "Rumunia", "Słowacja", "Hiszpania");

    public static void main(String[] args) {
        //wypiszmy wszystkie kraje !

        //0.0 klasyczna iteracja
        for (int i = 0; i < orangeEurope.size(); i++) {
            System.out.println(orangeEurope.get(i));
        }

        //0.1 syntactic sugar od Javy 5
        for(String country : orangeEurope) {
            System.out.println(country);
        }

        //1.0 Iterable.forEach z anonimowym Consumerem
        orangeEurope.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        //1.1 Iterable.forEach z wyrażeniem lambda spełniającym interfejs Consumer
        orangeEurope.forEach((final String name) -> { System.out.println(name); });

        //1.2 Iterable.forEach z wyrażeniem lambda (bez nawiasów)
        orangeEurope.forEach(name -> System.out.println(name));

        //1.3 Iterable.forEach z referencją na metodę
        orangeEurope.forEach(System.out::println);

        //2.0 iterowanie po intach InsStream
        IntStream.range(0,3).forEach(System.out::println);

    }
}
