package dd.javafunc.countries;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CountryAreaAndPopulation implements CountryStat {
    private String countryName_EN;
    private String countryName_PL;
    private String capital_EN;
    private String capital_PL;
    private Integer area;
    private List<NumericStatistic> population = new ArrayList<>();

    public CountryAreaAndPopulation(String name_EN, String name_PL, String capital_EN, String capital_PL, Integer area) {
        this.countryName_EN = name_EN;
        this.countryName_PL = name_PL;
        this.capital_EN = capital_EN;
        this.capital_PL = capital_PL;
        this.area = area;
    }

    void addPopulation(NumericStatistic population) {
        this.population.add(population);
    }

    public String getCountryName_EN() {
        return countryName_EN;
    }

    public String getCountryName_PL() {
        return countryName_PL;
    }

    public String getCapital_EN() {
        return capital_EN;
    }

    public String getCapital_PL() {
        return capital_PL;
    }

    public Stream<NumericStatisticWithCountryName> getPopulation() {
        return population
                .stream()
                .map(stat -> new NumericStatisticWithCountryName(countryName_PL, stat));
    }

    public Integer getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "CountryAreaAndPopulation{" +
                "countryName_EN='" + countryName_EN + '\'' +
                ", countryName_PL='" + countryName_PL + '\'' +
                ", capital_EN='" + capital_EN + '\'' +
                ", capital_PL='" + capital_PL + '\'' +
                ", area=" + area +
                ", population=" + population +
                '}';
    }
}
