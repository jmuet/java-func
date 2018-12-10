package dd.javafunc;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.function.BinaryOperator.maxBy;
import static java.util.stream.Collectors.*;

public class Ex9_Collect {
    final static List<Person> persons = Arrays.asList(
            new Person("Mark", 20),
            new Person("Andy", 13),
            new Person("Mike", 28),
            new Person("John", 33),
            new Person("Greg", 13),
            new Person("Dave", 17),
            new Person("Alex", 17),
            new Person("Lisa", 20)
    );

    public static void main(String[] args) {
        //0.0 wylistujmy osoby starsze niż 18 lat pogrupowane wg wieku - imperatywnie
        Map<Integer, List<Person>> grouped = new HashMap<>();
        for (Person person : persons) {
            if (person.getAge() > 18) {
                if (grouped.get(person.getAge()) == null)
                    grouped.put(person.getAge(), new ArrayList<>());
                grouped.get(person.getAge()).add(person);
            }
        }
        System.out.println(grouped);

        //1.0 wylistujmy osoby starsze niż 18 lat pogrupowane wg wieku - funkcyjnie; collect Collectors.groupingBy

        Map<Integer, List<Person>> collected = persons.stream()
                .filter(person -> person.getAge() > 18)
                .collect(groupingBy(Person::getAge));

        System.out.println(collected);

        //1.1 wylistujmy imiona pogrupowane wg wieku

        Map<Integer, List<String>> collected2 = persons.stream()
                .collect(groupingBy(Person::getAge, mapping(Person::getName, Collectors.toList())));

        System.out.println(collected2);

        //1.2 wylistujmy imiona pogrupowane wg pierwszej litery

        Map<Character, List<String>> collected3 = persons.stream()
                .collect(groupingBy(person -> person.getName().charAt(0),
                        mapping(Person::getName, Collectors.toList())));

        System.out.println(collected3);

        //1.3 wylistujmy najstarsze osoby pogrupowane wg pierwszej litery imienia

        Map<Character, Optional<Person>> collected4 = persons.stream()
                .collect(groupingBy(person -> person.getName().charAt(0),
                        reducing(maxBy(comparing(Person::getAge)))));

        System.out.println(collected4);
    }
}

class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ":" + age;
    }
}