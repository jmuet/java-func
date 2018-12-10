package dd.javafunc;

import dd.javafunc.countries.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex19_Countries {

    private static final String WORLD = "W o r l d";

    public static void main(String[] args) {
        countries();
    }

    private static void countries() {
        List<CountryAreaAndPopulation> countryList = CountryStatsReader.readCountries("res/gus_countries.csv");

        //1.0 - wypisać wszystkie angielskie nazwy krajów
        countryList.stream()
                .map(CountryAreaAndPopulation::getCountryName_EN)
                .forEach(System.out::println);

        //1.1 - jaka jest powierzchnia świata ("W O R L D" w pierwszej linii)
        countryList.stream()
            .filter(c -> c.getCountryName_EN().equalsIgnoreCase(WORLD))
            .mapToInt(CountryAreaAndPopulation::getArea)
            .forEach(System.out::println);

        //1.2 - suma powierzchni krajów (bez świata) - sum()
        System.out.println(countryList.stream()
                .filter(c -> !c.getCountryName_EN().equalsIgnoreCase(WORLD))
                .mapToInt(CountryAreaAndPopulation::getArea)
                .sum()
        );

        //1.3 - suma powierzchni krajów (bez świata) - reduce()
        System.out.println(countryList.stream()
                .filter(c -> !c.getCountryName_EN().equalsIgnoreCase(WORLD))
                .mapToInt(CountryAreaAndPopulation::getArea)
                .reduce(0, (n1, n2) -> n1 + n2)
        );

        //1.4 - ile stolic (angielskie nazwy) ma pierwszą literę "A", z użyciem Collectors.counting
        System.out.println(countryList.stream()
                .filter(c -> c.getCapital_EN().startsWith("A"))
                .collect(Collectors.counting())
        );

        //1.5 - najwyższa wartość populacji w dowolnym kraju w dowolnym roku
        System.out.println(countryList.stream()
                .filter(c -> !c.getCountryName_EN().equalsIgnoreCase(WORLD))
                .flatMap(CountryAreaAndPopulation::getPopulation)
                .max(Comparator.comparing(NumericStatistic::getValue))
                .get()
        );

        //1.6 - średnia powierzchnia kraju (jako double)
        System.out.println(countryList.stream()
                .mapToInt(CountryAreaAndPopulation::getArea)
                .skip(1)
                .average()
                .getAsDouble()
        );

        //1.7 - ile Rosja miała użytkowników internetu per 1000 mieszkańców w 2010?
        List<CountryInternetUsers> internetUsersList = CountryStatsReader.readInternetUsers("res/gus_internet_users.csv");
        System.out.println(internetUsersList.stream()
                .filter(c -> c.getCountryName_PL().equalsIgnoreCase("Rosja"))
                .flatMap(CountryInternetUsers::getUsersPerThousand)
                .filter(u -> u.getYear() == 2010)
                .findFirst()
                .get());

        //1.8 - ile Rosja miała użytkowników internetu w latach 2000 - 2010?
        List<NumericStatisticWithCountryName> rusUserPer1k = findByEnglishName("russia", CountryStatsReader.readInternetUsers("res/gus_internet_users.csv").stream())
                .getUsersPerThousand()
                .sorted(Comparator.comparingInt(NumericStatisticWithCountryName::getYear))
                .collect(Collectors.toList());

        List<NumericStatisticWithCountryName> rusPopulation = findByEnglishName("russia", CountryStatsReader.readCountries("res/gus_countries.csv").stream())
                .getPopulation()
                .sorted(Comparator.comparingInt(NumericStatisticWithCountryName::getYear))
                .collect(Collectors.toList());

        IntStream.range(0, Math.min(rusUserPer1k.size(), rusPopulation.size()))
                .mapToObj(i -> new NumericStatistic(rusPopulation.get(i).getYear(), rusPopulation.get(i).getValue() * rusUserPer1k.get(i).getValue() / 1000))
                .filter(stat -> stat.getYear() >= 2000 && stat.getYear() <= 2010)
                .forEach(System.out::println);

    }

    private static <T extends CountryStat> T findByEnglishName(String name, Stream<T> stream) {
        return stream.filter(c -> c.getCountryName_EN().equalsIgnoreCase(name)).findFirst().get();
    }

}
