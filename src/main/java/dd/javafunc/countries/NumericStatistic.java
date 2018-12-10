package dd.javafunc.countries;

public class NumericStatistic {
    Integer year;
    Long value;

    public NumericStatistic(Integer year, Long value) {
        this.year = year;
        this.value = value;
    }

    public Integer getYear() {
        return year;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NumericStatistic{" +
                "year=" + year +
                ", value=" + value +
                '}';
    }
}
