package dd.javafunc;

import dd.javafunc.countries.CountryAreaAndPopulation;
import dd.javafunc.countries.CountryStatsReader;

import java.util.List;

public class Ex19_Countries {

    private static final String WORLD = "W o r l d";

    public static void main(String[] args) {
        countries();
    }

    private static void countries() {
        List<CountryAreaAndPopulation> countryList = CountryStatsReader.readCountries("res/gus_countries.csv");

        //1.0 - wypisać wszystkie angielskie nazwy krajów

        //1.1 - jaka jest powierzchnia świata ("W O R L D" w pierwszej linii)

        //1.2 - suma powierzchni krajów (bez świata) - sum()

        //1.3 - suma powierzchni krajów (bez świata) - reduce()

        //1.4 - ile stolic (angielskie nazwy) ma pierwszą literę "A", z użyciem Collectors.counting

        //1.5 - najwyższa wartość populacji w dowolnym kraju w dowolnym roku

        //1.6 - średnia powierzchnia kraju (jako double)

        //1.7 - ile Rosja miała użytkowników internetu per 1000 mieszkańców w 2010?

        //1.8 - ile Rosja miała użytkowników internetu w latach 2000 - 2010?

    }

}
