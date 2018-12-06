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

    //1.0 dokończ implementację
    private final static void listFilesFunc(String dir) {
        Stream.of(new File(dir).listFiles());
            //...
    }

    public static void main(String[] args) {
        //wypiszmy wszystkie pliki w katalogu res
        listFiles("res");

        //funkcyjnie
        listFilesFunc("res");

        //funkcyjnie, dowolna głębokość filesystemu
//        listFilesFuncRecursive("res");
    }

}
