package dd.javafunc;

import java.util.Arrays;
import java.util.List;

public class Ex5_HigherOrderFunction {

    private final static List<Suchar> suchary = Arrays.asList(Suchar.dobry(), Suchar.przyzwoity(), Suchar.zFamiliady(), Suchar.odJanka());

    @FunctionalInterface
    interface SucharFilter {
        boolean jestOdpowiedni(Suchar suchar);
    }

    //2 zdefiniuj metodę która przyjmuje SucharFilter i używa go by wypisać wybrane suchary
    private static void wybierzSuchary(SucharFilter filter) {
    }

    public static void main(String[] args) {
        //3.0 wybierzSuchary z anonimowym SucharFiltrem

        //3.1 wybierzSuchary z lambdą

        //3.2 wybierzSuchary z referencją na metodę która spełnia SucharFilter
    }

}

class Suchar {
    private String temat;
    private int poziom;
    private boolean sfw;

    public int getPoziom() {
        return poziom;
    }

    public boolean isSafeForWork() {
        return sfw;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)%s", temat, poziom, sfw?"":", NSFW");
    }

    private Suchar(String temat, int poziom, boolean sfw) {
        this.temat = temat;
        this.poziom = poziom;
        this.sfw = sfw;
    }

    public static Suchar dobry() {
        return new Suchar("dobry suchar", 3, false);
    }

    public static Suchar przyzwoity() {
        return new Suchar("taki tam suchar", 2, true);
    }

    public static Suchar zFamiliady() {
        return new Suchar("po prostu suchar", 1, true);
    }

    public static Suchar odJanka() {
        return new Suchar("ale suchar",0, false);
    }
}