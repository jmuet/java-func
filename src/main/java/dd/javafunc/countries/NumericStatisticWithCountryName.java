package dd.javafunc.countries;

public class NumericStatisticWithCountryName extends NumericStatistic {

    private String countryName;

    public NumericStatisticWithCountryName(String countryName, NumericStatistic statistic) {
        super(statistic.year, statistic.value);
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "NumericStatisticWithCountryName{" +
                "countryName='" + countryName + '\'' +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
