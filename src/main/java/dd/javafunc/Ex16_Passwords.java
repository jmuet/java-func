package dd.javafunc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
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
        //1.0 ile jest haseł w pliku? (na wyjściu Long)

        //1.1 ile haseł nie ma żadnego znaku UPPERCASE (na wyjściu Long)

        //1.2 podzielmy hasła wg długości i policzmy ile było haseł w każdej grupie (na wyjściu Map<Integer, Long>)

        //1.3 znajdźmy najpopularniejszą długość hasła (na wyjściu Integer)
    }

}
