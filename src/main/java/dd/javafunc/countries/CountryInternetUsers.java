package dd.javafunc.countries;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CountryInternetUsers implements CountryStat {
    private String countryName_EN;
    private String countryName_PL;
    private List<NumericStatistic> usersPerThousand = new ArrayList<>();

    public CountryInternetUsers(String countryName_EN, String countryName_PL) {
        this.countryName_EN = countryName_EN;
        this.countryName_PL = countryName_PL;
    }

    void addInternetUsers(NumericStatistic users) {
        this.usersPerThousand.add(users);
    }

    public String getCountryName_EN() {
        return countryName_EN;
    }

    public String getCountryName_PL() {
        return countryName_PL;
    }

    public Stream<NumericStatisticWithCountryName> getUsersPerThousand() {
        return usersPerThousand
                .stream()
                .map(stat -> new NumericStatisticWithCountryName(countryName_PL, stat));
    }

    @Override
    public String toString() {
        return "CountryInternetUsers{" +
                "countryName_EN='" + countryName_EN + '\'' +
                ", countryName_PL='" + countryName_PL + '\'' +
                ", usersPerThousand=" + usersPerThousand +
                '}';
    }

}
