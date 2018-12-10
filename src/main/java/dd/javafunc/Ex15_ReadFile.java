package dd.javafunc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Ex15_ReadFile {

    private static void readFile(String name, Consumer<Stream<String>> reader) {
        try (Stream<String> stream = Files.lines(Paths.get("res/pass-top-100000.txt"))) {
            reader.accept(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        //1.0 wypiszmy pierwsze 10 linii pliku res/pass-top-100000.txt, z użyciem Files.lines
        try (Stream<String> stream = Files.lines(Paths.get("res/pass-top-100000.txt"))) {
            stream.limit(10)
            .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //1.1 wynieśmy try-with-resources do oddzielnej metody
        readFile("res/pass-top-100000.txt", stream -> stream.limit(10).forEach(System.out::println));
    }

}
