package lesson2;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"),
            new Person(1, "Harry"),
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        Arrays.stream(Optional.of(RAW_DATA).orElseThrow(NullPointerException::new)).distinct().sorted(Comparator.comparing(Person::getId).thenComparing(Person::getName))
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()))
                .forEach((k, v) -> System.out.printf("Key: %s\nValue:%d\n", k, v));

        System.out.println("**************************************************");

        System.out.println("Pair of numbers with sum 10" + findPairOfNumbers(Arrays.asList(3, 4, 2, 7), 10));

        System.out.println("**************************************************");
        System.out.println("Fuzzy search function done:");
        System.out.println();

        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false

    }

    public static boolean fuzzySearch(String expected, String stringToSearch) {
        int index = 0;
        for (int i = 0; i < stringToSearch.length(); i++) {
            if (expected.charAt(index) == stringToSearch.charAt(i)) {
                index++;
            }
            if (index == expected.length()) {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> findPairOfNumbers(List<Integer> array, int sum) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (array.get(i) + array.get(j) == sum) {
                    result.add(array.get(i));
                    result.add(array.get(j));
                    return result;
                }
            }
        }
        return null;
    }

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}