package dd.javafunc;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ex13_Files {

    private final static void listTxtFiles(String dir) {
        String[] files = new File(dir).list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        for (String s : files) {
            System.out.println(s);
        }
    }

    private final static void listTxtFilesFunc(String dir) throws IOException {
        Files.newDirectoryStream(Paths.get(dir), path -> path.toString().endsWith(".txt"))
            .forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        listTxtFiles("res");

        //1.0 wypiszmy pliki .txt w /res - z użyciem Files.newDirectoryStream
        listTxtFilesFunc("res");
    }

}
