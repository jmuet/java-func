package dd.javafunc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex14_Subdirs {

    private final static void listFiles(String dir) {
        List<File> files = new ArrayList<>();

        File[] filesInCurrentDir = new File(dir).listFiles();
        for (File file : filesInCurrentDir) {
            File[] filesInSubdir = file.listFiles();
            if (filesInSubdir != null) {
                files.addAll(Arrays.asList(filesInSubdir));
            } else {
                files.add(file);
            }
        }

        for (File file : files) {
            System.out.println(file);
        }

    }

    private final static void listFilesFunc(String dir) {
        Stream.of(new File(dir).listFiles())
            .flatMap(file -> file.listFiles() == null ? Stream.of(file) : Stream.of(file.listFiles()))
            .forEach(System.out::println);
    }

    private final static void listFilesFuncRecursive(String dir) {
        getFileStream(new File(dir))
                .forEach(System.out::println);
    }

    private static Stream<File> getFileStream(File rootFile) {
        return Stream.of(rootFile.listFiles())
            .flatMap(file -> file.listFiles() == null ? Stream.of(file) : getFileStream(file));
    }

    public static void main(String[] args) {
        //wypiszmy wszystkie pliki w katalogu res
        listFiles("res");

        //1.0 funkcyjnie
        listFilesFunc("res");

        //1.1 funkcyjnie, dowolna głębokość filesystemu
        listFilesFuncRecursive("res");
    }

}
