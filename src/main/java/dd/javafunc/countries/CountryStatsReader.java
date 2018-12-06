package dd.javafunc.countries;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountryStatsReader {

    public static List<CountryAreaAndPopulation> readCountries(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream.skip(1)
                    .map(CountryStatsReader::countryAreaAndPopulation)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static CountryAreaAndPopulation countryAreaAndPopulation(String str) {
        String[] split = str.split(",");
        String name_PL = split[0].split("/")[0].trim();
        String name_EN = split[0].split("/")[1].trim();
        String capital_PL = "";
        String capital_EN = "";
        if (split[1].contains("/")) {
            capital_PL = split[1].split("/")[0].trim();
            capital_EN = split[1].split("/")[1].trim();
        }
        Integer area = Integer.parseInt(split[2]);
        CountryAreaAndPopulation country = new CountryAreaAndPopulation(name_EN, name_PL, capital_EN, capital_PL, area);
        final int numberStartingColumn = 3;
        for (int i = numberStartingColumn; i < split.length; i++) {
            country.addPopulation(new NumericStatistic(i == numberStartingColumn ? 1995 : 1999 + i - numberStartingColumn, Long.parseLong(split[i])));
        }
        return country;
    }

    public static List<CountryInternetUsers> readInternetUsers(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream.skip(1)
                    .map(CountryStatsReader::countryInternetUsers)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static CountryInternetUsers countryInternetUsers(String str) {
        String[] split = str.split(",");
        String name_PL = split[0].split("/")[0].trim();
        String name_EN = split[0].split("/")[1].trim();
        CountryInternetUsers country = new CountryInternetUsers(name_EN, name_PL);
        final int numberStartingColumn = 1;
        for (int i = numberStartingColumn; i < split.length; i++) {
            long value;
            try {
                value = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {  //cell did not contain a value
                value = -1;
            }
            country.addInternetUsers(new NumericStatistic(i == numberStartingColumn ? 1995 : 1999 + i - numberStartingColumn, value));
        }
        return country;
    }
}
