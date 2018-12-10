package dd.javafunc;

import java.util.function.Function;

public class Ex17_KalkulatorŚwiatłowodu {

    static class KalkulatorCeny {
        final static double CENA_BAZOWA = 100;
        final boolean debugujemy = false;

        //!! debug
        private Function<Double, Double> debug(String msg, Function<Double, Double> fun) {
            if (!debugujemy)
                return fun;

            return (x) -> {
                Double output = fun.apply(x);
                System.out.println(String.format("%s %.2f -> %.2f", msg, x, output));
                return output;
            };
        }

        //10PLN ekstra za umowy do roku
        private Function<Double, Double> zwyżkaZaKrótkąUmowę(int wartość, int długość) {
            return (x) -> (x + (długość < 12 ? wartość : 0.0));
        }

        //5% zniżki za każde wysłużone 3 lata
        private Function<Double, Double> zniżkaZaStażKlienta(int staż) {
            return (x) -> (x * (1.0 - (Math.floor(staż / 3) * 0.05)));
        }
        //10% zniżki gdy ktoś ma komórkę
        private Function<Double, Double> zniżkaZaFix = (x) -> (x * 0.95);

        //10% zniżki gdy ktoś ma telefon fix
        private Function<Double, Double> zniżkaZaMobile = (x) -> (x * 0.9);

        private Function<Double, Double> bezZmian = Function.identity();

        private Function<Double, Double> strategiaCenowa(InstalacjaŚwiatłowoduZapytanie zapytanie) {
            switch (zapytanie.typKlienta()) {
                case INDIVIDUAL: return strategiaDlaKlientaIndywidualnego(zapytanie);
                case BUSINESS: return strategiaDlaKlientaBiznesowego(zapytanie);
                case VIP: return (x) -> (x * 0.5);
            }
            return Function.identity();
        }

        //ZADANIE - implementacja strategii naliczającej, w kolejności:
        //zwyżkę 10 PLN / miesiąc jeśli umowa trwa do 12 miesięcy
        //1% zniżki za każdy rok stażu klienta (przykładowo, dla 5 lat to będzie 5%)
        //5 % zniżki miesięcznie jeśli klient posiada telefon komórkowy
        //7.5 PLN zniżki miesięcznie jeśli klient posiada telefon stacjonarny
        private Function<Double, Double> strategiaDlaKlientaIndywidualnego(InstalacjaŚwiatłowoduZapytanie zapytanie) {
                return debug("zwyżka za krótką umowę", zwyżkaZaKrótkąUmowę(10, zapytanie.długośćUmowyMiesiące()))
                        .andThen(debug("zniżka za staż", zniżkaZaStażKlienta(zapytanie.stażKlientaLata())))
                        .andThen(zapytanie.czyMaTelefonKomórkowy() ? debug("zniżka mobile", zniżkaZaMobile) : bezZmian)
                        .andThen(zapytanie.czyMaTelefonStacjonarny() ? debug("zniżka fix", zniżkaZaFix) : bezZmian);
        }

        //ZADANIE - implementacja strategii naliczającej, w kolejności:
        //zwyżkę 20 PLN / miesiąc jeśli umowa trwa do 12 miesięcy
        //1% zniżki za każdy rok stażu klienta (przykładowo, dla 5 lat to będzie 5%)
        private Function<Double, Double> strategiaDlaKlientaBiznesowego(InstalacjaŚwiatłowoduZapytanie zapytanie) {
            return debug("zwyżka za krótką umowę", zwyżkaZaKrótkąUmowę(20, zapytanie.długośćUmowyMiesiące()))
                    .andThen(debug("zniżka za staż", zniżkaZaStażKlienta(zapytanie.stażKlientaLata())));
        }

        public double obliczMiesięcznąOpłatę(InstalacjaŚwiatłowoduZapytanie zapytanie) {
            return strategiaCenowa(zapytanie).apply(CENA_BAZOWA);
        }
    }

    public static void main(String[] args) {
        KalkulatorCeny kalkulator = new KalkulatorCeny();
        System.out.println("ceny światłowodu:");
        System.out.println("nowy klient indywidualny: "+kalkulator.obliczMiesięcznąOpłatę(InstalacjaŚwiatłowoduZapytanie.dlaNowegoKlientaIndywidualnego(6)));
        System.out.println("klient z usługami i stażem: " + kalkulator.obliczMiesięcznąOpłatę(InstalacjaŚwiatłowoduZapytanie.dlaUpaczkowionegoKlientaIndywidualnego(6, 10)));
        System.out.println("nowy klient biznesowy: " + kalkulator.obliczMiesięcznąOpłatę(InstalacjaŚwiatłowoduZapytanie.dlaNowegoKlientaBiznesowego(6)));
    }

}

class InstalacjaŚwiatłowoduZapytanie {
    private CustomerType typKlienta;
    private int długośćUmowyMiesiące;
    private int stażKlientaLata;
    private boolean maTelefonKomórkowy;
    private boolean maTelefonStacjonarny;

    public CustomerType typKlienta() {
        return typKlienta;
    }

    public int długośćUmowyMiesiące() {
        return długośćUmowyMiesiące;
    }

    public int stażKlientaLata() {
        return stażKlientaLata;
    }

    public boolean czyMaTelefonKomórkowy() {
        return maTelefonKomórkowy;
    }

    public boolean czyMaTelefonStacjonarny() {
        return maTelefonStacjonarny;
    }

    public InstalacjaŚwiatłowoduZapytanie(CustomerType typKlienta, int długośćUmowyMiesiące, int stażKlientaLata, boolean maTelefonKomórkowy, boolean maTelefonStacjonarny) {
        this.typKlienta = typKlienta;
        this.długośćUmowyMiesiące = długośćUmowyMiesiące;
        this.stażKlientaLata = stażKlientaLata;
        this.maTelefonKomórkowy = maTelefonKomórkowy;
        this.maTelefonStacjonarny = maTelefonStacjonarny;
    }

    public static InstalacjaŚwiatłowoduZapytanie dlaNowegoKlientaIndywidualnego(int długośćUmowyMiesiące) {
        return new InstalacjaŚwiatłowoduZapytanie(CustomerType.INDIVIDUAL, długośćUmowyMiesiące, 0, false, false);
    }

    public static InstalacjaŚwiatłowoduZapytanie dlaNowegoKlientaBiznesowego(int długośćUmowyMiesiące) {
        return new InstalacjaŚwiatłowoduZapytanie(CustomerType.BUSINESS, długośćUmowyMiesiące, 0, false, false);
    }

    public static InstalacjaŚwiatłowoduZapytanie dlaUpaczkowionegoKlientaIndywidualnego(int długośćUmowyMiesiące, int stażKlientaLata) {
        return new InstalacjaŚwiatłowoduZapytanie(CustomerType.INDIVIDUAL, długośćUmowyMiesiące, stażKlientaLata, true, true);
    }
}

enum CustomerType {
    INDIVIDUAL, BUSINESS, VIP
}

