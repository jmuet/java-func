package dd.javafunc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex16_Passwords {

    private String fileName;

    public Ex16_Passwords(String fileName) {
        this.fileName = fileName;
    }

    public void analyse(Consumer<Stream<String>> analyser) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            analyser.accept(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Ex16_Passwords passwordAnalyser = new Ex16_Passwords("res/pass-top-100000.txt");
        //1.0 ile haseł w pliku? (na wyjściu Long)
        passwordAnalyser.analyse(stream -> {
            Long count = stream.count();
            System.out.println(count);
        });

        //1.1 ile haseł nie ma żadnego znaku UPPERCASE (na wyjściu Long)
        passwordAnalyser.analyse(stream -> {
            Long lowerCaseOnly = stream
                    .filter(pass -> pass.toLowerCase().equals(pass))
                    .count();
            System.out.println(lowerCaseOnly);
        });

        //1.2 podzielmy hasła wg długości i policzmy ile było haseł w każdej grupie (na wyjściu Map<Integer, Long>)
        passwordAnalyser.analyse(stream -> {
            Map<Integer, Long> countByLength = stream.collect(Collectors.groupingBy(String::length, Collectors.reducing(0L, e -> 1L, Long::sum)));
            countByLength.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
        });

        //1.3 znajdźmy najpopularniejszą długość hasła (na wyjściu Integer)
        passwordAnalyser.analyse(stream -> {
            Integer mostPopularLength = stream.collect(Collectors.groupingBy(String::length, Collectors.reducing(0L, e -> 1L, Long::sum)))
                    .entrySet().stream()
                    .max(Comparator.comparingLong(Map.Entry::getValue))
                    .map(Map.Entry::getKey)
                    .get();
            System.out.println(mostPopularLength);
        });
    }

}
