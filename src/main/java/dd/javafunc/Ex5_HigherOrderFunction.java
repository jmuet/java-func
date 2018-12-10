package dd.javafunc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex5_HigherOrderFunction {

    private final static List<Suchar> suchary = Arrays.asList(Suchar.dobry(), Suchar.przyzwoity(), Suchar.zFamiliady(), Suchar.odJanka());

    //----------------------
    //1 zdefiniuj własny interfejs funkcyjny SucharFilter
    @FunctionalInterface
    interface SucharFilter {
        boolean jestOdpowiedni(Suchar suchar);
    }

    //2 zdefiniuj metodę która przyjmuje SucharFilter i używa go by wybrać odpowiednie suchary
    private static void wybierzSuchary(SucharFilter filter) {
        System.out.println(
            suchary.stream()
                    .flatMap(suchar -> filter.jestOdpowiedni(suchar) ? Stream.of(suchar) : Stream.empty())
                    .collect(Collectors.toList())
        );
    }

    private static boolean sucharJestBezpieczny(Suchar suchar) {
        return suchar.isSafeForWork();
    }

    public static void main(String[] args) {
        //3.0 wybierzSuchary z anonimowym SucharFiltrem
        wybierzSuchary(new SucharFilter() {
            @Override
            public boolean jestOdpowiedni(Suchar suchar) {
                return suchar.isSafeForWork();
            }
        });

        //3.1 wybierzSuchary z lambdą
        wybierzSuchary(suchar -> suchar.isSafeForWork());

        //3.2 wybierzSuchary z referencją na metodę która spełnia SucharFilter
        wybierzSuchary(Ex5_HigherOrderFunction::sucharJestBezpieczny);
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